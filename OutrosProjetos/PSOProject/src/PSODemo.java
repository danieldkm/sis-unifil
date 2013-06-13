import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.Random;
import java.text.DecimalFormat;

/*--------------------------------------------------------------------*/
public class PSODemo extends JFrame implements Runnable {
	/*--------------------------------------------------------------------*/

	private static final long serialVersionUID = 1L;
	private static final Font font = new Font("Dialog", Font.BOLD, 12);
	private static final Font small = new Font("Dialog", Font.PLAIN, 10);
	
	private boolean isprog = false; /* whether run as a program / se executado como um programa*/
	private JScrollPane scroll = null; /* scroll pane viewport / painel de rolagem viewport*/
	private PSOPanel panel = null; /* part. swarm viewer panel / parte. enxame espectador painel*/
	private JTextField stat = null; /* status bar for messages / barra de status para mensagens*/
	private JDialog fnsel = null; /* select function dialog box / marque a caixa de diálogo da função*/
	private JDialog swarm = null; /* create swarm dialog box / criar caixa de diálogo enxame*/
	private JDialog runopt = null; /* run opt. dialog box / executar opt. caixa de diálogo*/
	private JDialog about = null; /* "About..." dialog box / "Sobre ..." caixa de diálogo*/
	private JFileChooser chooser = null; /* a file chooser / um seletor de arquivos*/
	private DecimalFormat fmt = null; /* formatter for numbers / formatador para números*/
	private Timer timer = null; /* timer for repeated update / temporizador para atualização repetido*/
	private int cnt = -1; /* counter for epochs / contador para épocas*/
	private int mode = 0; /* mouse operation mode / modo de operação do mouse*/
	private int mx, my; /* mouse coordinates / coordena o mouse*/
	private double scale, factor; /* buffer for scaling factor / buffer para fator de escala*/

	/*------------------------------------------------------------------*/
	
	private JFileChooser createChooser() { /* --- create a file chooser / criar um seletor de arquivos*/
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setFileHidingEnabled(true);
		fc.setAcceptAllFileFilterUsed(true);
		fc.setMultiSelectionEnabled(false);
		fc.setFileView(null); /* create a standard file chooser / criar um seletor de arquivos padrão*/
		return fc; /* without customized filters / sem filtros personalizados*/
	} /* createChooser() */

	/*------------------------------------------------------------------*/

	public void saveImage(File file) { /* --- save image to a file / salvar a imagem em um arquivo */
		if (file == null) { /* if no file name is given / Se nenhum nome de arquivo for fornecido*/
			if (this.chooser == null)
				this.chooser = this.createChooser();
			this.chooser.setDialogType(JFileChooser.SAVE_DIALOG);
			int r = this.chooser.showDialog(this, null);
			if (r != JFileChooser.APPROVE_OPTION)
				return;
			file = this.chooser.getSelectedFile();
		} /* let the user choose a file name / permitir que o usuário escolha um nome de arquivo*/
		try { /* open an output stream / abrir um fluxo de saída*/
			FileOutputStream stream = new FileOutputStream(file);
			ImageIO.write(this.panel.makeImage(), "png", stream);
			stream.close();
		} /* save the decision tree image / salvar a imagem da árvore de decisão */
		catch (IOException e) { /* catch and report i/o errors  / capturar e relatar os erros do i/o */
			String msg = e.getMessage();
			stat.setText(msg);
			System.err.println(msg);
			JOptionPane.showMessageDialog(this, msg, "Error",
					JOptionPane.ERROR_MESSAGE);
		} /* set the status text / definir o texto de status*/
	} /* saveImage() */

	/*------------------------------------------------------------------*/
	private JDialog createFnSel() { /* --- create "Select..." dialog / criar "Selecionar ..." diálogo*/
		final JDialog dlg = new JDialog(this, "Selecione a Função..." /*Select Function...*/);
		GridBagLayout g = new GridBagLayout();
		GridBagConstraints lc = new GridBagConstraints();
		GridBagConstraints rc = new GridBagConstraints();
		JPanel grid = new JPanel(g);
		JPanel bbar;
		JLabel lbl;
		JButton btn;

		grid.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		lc.fill = /* fill fields in both directions / preencher campos em ambas as direcções*/
		rc.fill = GridBagConstraints.BOTH;
		rc.weightx = 1.0; /* resize only the input fields, / redimensionar apenas os campos de entrada,*/
		lc.weightx = 0.0; /* but not the labels / mas não os rótulos*/
		lc.weighty = 0.0; /* resize lines equally / redimensionar linhas igualmente*/
		rc.weighty = 0.0; /* in vertical direction / na direção vertical*/
		lc.ipadx = 10; /* gap between labels and inputs / espaço entre as etiquetas e os insumos*/
		lc.ipady = 10; /* make all lines of the same height / fazer todas as linhas da mesma altura*/
		rc.gridwidth = GridBagConstraints.REMAINDER;

		lbl = new JLabel("Função para otimizar:"/*Function to optimize:*/);
		g.setConstraints(lbl, lc);
		grid.add(lbl);
		final JComboBox selfn = new JComboBox(new String[] { "parabola",
				"circles 1", "circles 2", "eggbox 1", "eggbox 2" });
		selfn.setSelectedIndex(0);
		g.setConstraints(selfn, rc);
		grid.add(selfn);

		bbar = new JPanel(new GridLayout(1, 2, 5, 5));
		bbar.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 3));
		btn = new JButton("Ok");
		bbar.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
				PSODemo.this.panel.setFn(selfn.getSelectedIndex());
				PSODemo.this.stat.setText("conjunto de funções."/*function set.*/);
			}
		});
		btn = new JButton("Aplicação"/*Apply"*/);
		bbar.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PSODemo.this.panel.setFn(selfn.getSelectedIndex());
				PSODemo.this.stat.setText("função objetivo definido."/*objective function set.*/);
			}
		});
		btn = new JButton("Cancelar"/*Cancel*/);
		bbar.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
			}
		});

		dlg.getContentPane().add(grid, BorderLayout.CENTER);
		dlg.getContentPane().add(bbar, BorderLayout.SOUTH);
		dlg.setLocationRelativeTo(this);
		dlg.setLocation(664, 0);
		dlg.pack();
		return dlg;
	} /* createFnSel() */

	/*------------------------------------------------------------------*/
	
	private JDialog createSwarm() { /* --- create swarm dialog / criar diálogo enxame*/
		final JDialog dlg = new JDialog(this, "Criar Particulas de enxame..."/*Create Particle Swarm...*/);
		GridBagLayout g = new GridBagLayout();
		GridBagConstraints lc = new GridBagConstraints();
		GridBagConstraints rc = new GridBagConstraints();
		JPanel grid = new JPanel(g);
		JPanel bbar;
		JLabel lbl;
		JTextArea help;
		JButton btn;

		grid.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		lc.fill = /* fill fields in both directions / preencher campos em ambas as direcções*/
		rc.fill = GridBagConstraints.BOTH;
		rc.weightx = 1.0; /* resize only the input fields, / redimensionar apenas os campos de entrada,*/
		lc.weightx = 0.0; /* but not the labels / mas não os rótulos*/
		lc.weighty = 0.0; /* resize lines equally / redimensionar linhas igualmente*/
		rc.weighty = 0.0; /* in vertical direction / na direção vertical*/
		lc.ipadx = 10; /* gap between labels and inputs / espaço entre as etiquetas e os insumos*/
		lc.ipady = 10; /* make all lines of the same height / fazer todas as linhas da mesma altura*/
		rc.gridwidth = GridBagConstraints.REMAINDER;

		lbl = new JLabel("Números de particulas"/*Number of particles:*/);
		g.setConstraints(lbl, lc);
		grid.add(lbl);
		final JSpinner parcnt = new JSpinner(new SpinnerNumberModel(30, 1,
				999999, 1));
		g.setConstraints(parcnt, rc);
		grid.add(parcnt);

		lbl = new JLabel("Comprimento da cauda (história):"/*Tail length (history):*/);
		g.setConstraints(lbl, lc);
		grid.add(lbl);
		final JSpinner tailen = new JSpinner(new SpinnerNumberModel(2, 0, 100,
				1));
		g.setConstraints(tailen, rc);
		grid.add(tailen);

		lbl = new JLabel("Semente para números aleatórios:"/*Seed for random numbers:"*/);
		g.setConstraints(lbl, lc);
		grid.add(lbl);
		final JSpinner seed = new JSpinner(new SpinnerNumberModel(0, 0, 999999,
				1));
		g.setConstraints(seed, rc);
		grid.add(seed);

		help = new JTextArea(
				"Se a semente para o gerador de números pseudo-aleatório \n" +
				"é definido para zero, a hora do sistema será usado"
				/*"If the seed for the pseudo-random number generator\n"
						+ "is set to zero, the system time will be used instead."*/);
		help.setFont(small);
		help.setEditable(false);
		help.setBackground(this.getBackground());
		g.setConstraints(help, rc);
		grid.add(help);

		lbl = new JLabel("Fator de Aceleração:"/*Acceleration factor:"*/);
		g.setConstraints(lbl, lc);
		grid.add(lbl);
		final JTextField accel = new JTextField("1");
		accel.setFont(font);
		g.setConstraints(accel, rc);
		grid.add(accel);

		lbl = new JLabel("Fator de desaceleração inicial:"/*Initial deceleration factor:"*/);
		g.setConstraints(lbl, lc);
		grid.add(lbl);
		final JTextField decel = new JTextField("1");
		decel.setFont(font);
		g.setConstraints(decel, rc);
		grid.add(decel);

		lbl = new JLabel("Desaceleração decadência fator:"/*Deceleration factor decay:"*/);
		g.setConstraints(lbl, lc);
		grid.add(lbl);
		final JTextField decay = new JTextField("0.03");
		decay.setFont(font);
		g.setConstraints(decay, rc);
		grid.add(decay);

		bbar = new JPanel(new GridLayout(1, 2, 5, 5));
		bbar.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 3));
		btn = new JButton("Ok");
		bbar.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
				int s = ((Integer) seed.getValue()).intValue();
				PSODemo.this.panel.createSwarm(((Integer) parcnt.getValue())
						.intValue(), ((Integer) tailen.getValue()).intValue(),
						Double.parseDouble(accel.getText()), Double
								.parseDouble(decel.getText()), Double
								.parseDouble(decay.getText()),
						(s != 0) ? new Random(s) : new Random());
				PSODemo.this.stat.setText("enxame criado"/*swarm created"*/);
			}
		});
		btn = new JButton("Aplicar"/*Apply"*/);
		bbar.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int s = ((Integer) seed.getValue()).intValue();
				PSODemo.this.panel.createSwarm(((Integer) parcnt.getValue())
						.intValue(), ((Integer) tailen.getValue()).intValue(),
						Double.parseDouble(accel.getText()), Double
								.parseDouble(decel.getText()), Double
								.parseDouble(decay.getText()),
						(s != 0) ? new Random(s) : new Random());
				PSODemo.this.stat.setText("enxame criado"/*swarm created"*/);
			}
		});
		btn = new JButton("Fechar"/*Close"*/);
		bbar.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
			}
		});

		dlg.getContentPane().add(grid, BorderLayout.CENTER);
		dlg.getContentPane().add(bbar, BorderLayout.SOUTH);
		dlg.setLocationRelativeTo(this);
		dlg.setLocation(664, 94);
		dlg.pack();
		return dlg;
	} /* createSwarm() */

	/*------------------------------------------------------------------*/

	private String msg() { /* --- create status message / criar mensagem de status*/
		if (this.fmt == null)
			this.fmt = new DecimalFormat("0.000000");
		return "passo: "/*step: "*/ + this.panel.getStep() + ", o melhor: "+/*best:*/ "f("
				+ this.fmt.format(this.panel.getBestX()) + ","
				+ this.fmt.format(this.panel.getBestY()) + ") = "
				+ this.fmt.format(this.panel.getBest());
	} /* msg() */

	/*------------------------------------------------------------------*/

	private void updateSwarm(int epochs, int delay) { /* --- move the swarm / mover o enxame*/
		if (this.cnt >= 0) { /* check for running update /verifique para a execução de atualização */
			this.timer.stop();
			this.cnt = -1;
			return;
		}
		if (!this.panel.hasSwarm())
			return;
		if (delay <= 0) { /* if to update at the end / se atualizar no final*/
			while (--epochs >= 0)
				/* while more epochs to compute, / enquanto mais épocas para calcular,*/
				this.panel.updateSwarm(); /* move the swarm / mover o enxame*/
			this.panel.repaint(); /* redraw the window contents / redesenhar o conteúdo da janela*/
			this.stat.setText(this.msg());
			return; /* show a status message, / mostrar uma mensagem de status,*/
		} /* then abort the function / então abortar a função*/
		this.cnt = epochs; /* note the epochs / observar as épocas*/
		this.timer = new Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (--PSODemo.this.cnt < 0) {
					PSODemo.this.timer.stop();
					return;
				}
				PSODemo.this.panel.updateSwarm(); /* move the swarm and / mover o enxame e */
				PSODemo.this.panel.repaint(); /* redraw the window contents / redesenhar o conteúdo da janela*/
				PSODemo.this.stat.setText(PSODemo.this.msg());
			}
		}); /* update the status text / atualizar o texto de status*/
		this.timer.start(); /* start the status update timer / iniciar o temporizador de atualização de status*/
	} /* updateSwarm() */

	/*------------------------------------------------------------------*/

	private JDialog createRunOpt() { /* --- create run dialog / criar correr diálogo*/
		final JDialog dlg = new JDialog(this, "Executar Otimização..."/* Run Optimization..."*/);
		GridBagLayout g = new GridBagLayout();
		GridBagConstraints lc = new GridBagConstraints();
		GridBagConstraints rc = new GridBagConstraints();
		JPanel grid = new JPanel(g);
		JPanel bbar;
		JLabel lbl;
		JButton btn;
		grid.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		lc.fill = /* fill fields in both directions / preencher campos em ambas as direcções*/
		rc.fill = GridBagConstraints.BOTH;
		rc.weightx = 1.0; /* resize only the input fields, / redimensionar apenas os campos de entrada,*/
		lc.weightx = 0.0; /* but not the labels / mas não os rótulos*/
		lc.weighty = 0.0; /* resize lines equally / redimensionar linhas igualmente*/
		rc.weighty = 0.0; /* in vertical direction / na direção vertical*/
		lc.ipadx = 10; /* gap between labels and inputs / espaço entre as etiquetas e os insumos*/
		lc.ipady = 10; /* make all lines of the same height / fazer todas as linhas da mesma altura*/
		rc.gridwidth = GridBagConstraints.REMAINDER;

		lbl = new JLabel("Número de épocas:"/*Number of epochs:"*/);
		g.setConstraints(lbl, lc);
		grid.add(lbl);
		final JSpinner epochs = new JSpinner(new SpinnerNumberModel(5000, 1,
				999999, 1));
		g.setConstraints(epochs, rc);
		grid.add(epochs);

		lbl = new JLabel("Atraso entre épocas:"/*Delay between epochs:"*/);
		g.setConstraints(lbl, lc);
		grid.add(lbl);
		final JSpinner delay = new JSpinner(new SpinnerNumberModel(100, 0,
				999999, 10));
		g.setConstraints(delay, rc);
		grid.add(delay);

		bbar = new JPanel(new GridLayout(1, 2, 5, 5));
		bbar.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 3));
		btn = new JButton("Ok");
		bbar.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
				PSODemo.this.updateSwarm(
						((Integer) epochs.getValue()).intValue(),
						((Integer) delay.getValue()).intValue());
			}
		});
		btn = new JButton("Aplicar"/*Apply"*/);
		bbar.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PSODemo.this.updateSwarm(
						((Integer) epochs.getValue()).intValue(),
						((Integer) delay.getValue()).intValue());
			}
		});
		btn = new JButton("Fechar"/*Close"*/);
		bbar.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
			}
		});

		dlg.getContentPane().add(grid, BorderLayout.CENTER);
		dlg.getContentPane().add(bbar, BorderLayout.SOUTH);
		dlg.setLocationRelativeTo(this);
		dlg.setLocation(664, 339);
		dlg.pack();
		return dlg;
	} /* createRunOpt() */

	/*------------------------------------------------------------------*/

	private JDialog createAbout() { /* --- create "About..." dialog box / criar "Sobre ..." caixa de diálogo*/
		final JDialog dlg = new JDialog(this, "About PSODemo...", true);
		Container pane = dlg.getContentPane();
		LogoPanel logo = new LogoPanel();
		JButton btn = new JButton("Ok");
		JPanel rest = new JPanel(new BorderLayout(2, 2));
		JTextArea text = new JTextArea("PSODemo\n"
				+ "A Particle Swarm Optimization Demo\n"
				+ "Version 1.1, 2005.12.02\n\n"
				+ "written by Christian Borgelt\n"
				+ "Otto-von-Guericke-University of Magdeburg\n"
				+ "Universitatsplatz 2, D-39106 Magdeburg\n"
				+ "e-mail: borgelt@iws.cs.uni-magdeburg.de");
		text.setBackground(this.getBackground());
		text.setFont(new Font("Dialog", Font.BOLD, 12));
		text.setEditable(false);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
			}
		});
		rest.add(logo, BorderLayout.NORTH);
		rest.add(btn, BorderLayout.SOUTH);
		pane.setLayout(new FlowLayout());
		pane.add(text);
		pane.add(rest);
		dlg.setLocationRelativeTo(this);
		dlg.pack();
		dlg.setResizable(false);
		return dlg;
	} /* createAbout() */

	/*------------------------------------------------------------------*/
	public void run() { /* --- create GUI of swarm viewer / criar GUI do enxame espectador*/
		JMenuBar mbar; /* menu bar / barra de menu*/
		JMenu menu; /* to create menu titles / para criar títulos de menu*/
		JMenuItem item; /* to create menu items / para criar itens de menu*/

		this.getContentPane().setLayout(new BorderLayout());

		/* --- create and set the menu bar --- criar e configurar a barra de menu*/
		mbar = new JMenuBar();
		this.getContentPane().add(mbar, BorderLayout.NORTH);

		menu = mbar.add(new JMenu("Arquivo"/*File"*/));
		item = menu.add(new JMenuItem("Salvar Imagem em PNG..."/*Save PNG Image..."*/));
		item.setMnemonic('i');
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PSODemo.this.saveImage(null);
			}
		});
		menu.addSeparator();
		item = menu.add(new JMenuItem("Sair"/*Quit"*/));
		item.setMnemonic('q');
		if (this.isprog) { /* if stand-alone program /se o programa stand-alone */
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			
			
		} /* terminate the program / terminar o programa*/
		else { /* if only visualization module / se apenas o módulo de visualização*/
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (PSODemo.this.about != null)
						PSODemo.this.about.setVisible(false);
					PSODemo.this.setVisible(false);
				}				
			}); /* only close the window / só fechar a janela*/
		} /* and the dialog boxes / e as caixas de diálogo*/

		menu = mbar.add(new JMenu("Ações"/*Actions"*/));
		menu.setMnemonic('a');
		item = menu.add(new JMenuItem("Selecione a Função..."/* Select Function..."*/));
		item.setMnemonic('c');
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PSODemo.this.fnsel == null)
					PSODemo.this.fnsel = PSODemo.this.createFnSel();
				PSODemo.this.fnsel.setVisible(true);
			}
		});
		item = menu.add(new JMenuItem("Criar Particuas de enxame..."/*Create Particle Swarm..."*/));
		item.setMnemonic('c');
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PSODemo.this.swarm == null)
					PSODemo.this.swarm = PSODemo.this.createSwarm();
				PSODemo.this.swarm.setVisible(true);
			}
		});
		item = menu.add(new JMenuItem("Executar Otimização..."/*Run Optimization..."*/));
		item.setMnemonic('o');
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PSODemo.this.runopt == null)
					PSODemo.this.runopt = PSODemo.this.createRunOpt();
				PSODemo.this.runopt.setVisible(true);
			}
		});
		menu.addSeparator();
		item = menu.add(new JMenuItem("Redesenhar"/*Redraw"*/));
		item.setMnemonic('r');
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PSODemo.this.panel.repaint();
			}
		});

		menu = mbar.add(new JMenu("Ajuda"/*Help"*/));
		menu.setMnemonic('h');
		item = menu.add(new JMenuItem("Sobre"/*About..."*/));
		item.setMnemonic('a');
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PSODemo.this.about == null)
					PSODemo.this.about = PSODemo.this.createAbout();
				PSODemo.this.about.setVisible(true);
			}
		});

		/* --- create and set the main panel --- criar e definir o painel principal*/
		this.panel = new PSOPanel();
		this.panel.setLayout(new BorderLayout());
		this.panel.setPreferredSize(new Dimension(656, 656));
		this.getContentPane().add(this.panel, BorderLayout.CENTER);

		/* --- create and set a status bar --- criar e configurar uma barra de status*/
		this.stat = new JTextField("");
		this.stat.setEditable(false);
		this.getContentPane().add(this.stat, BorderLayout.SOUTH);

		/* --- show the frame window --- mostrar a janela do quadro*/
		this.setTitle("PSODemo");
		this.setDefaultCloseOperation(this.isprog ? JFrame.EXIT_ON_CLOSE
				: JFrame.HIDE_ON_CLOSE);
		this.setLocation(0, 0);
		this.pack();
		if (this.isprog)
			this.setVisible(true);
		this.stat.setText("PSODemo está instalado e funcionando."/*is up and running."*/);
	} /* run() */

	/* Following the recommendations in the Java tutorial, the user */
	/* interface is created in the "run" method, which is invoked */
	/* from the event queue, in order to avoid problems with threads. */
/*	Seguindo as recomendações do tutorial Java, o usuário
	interface é criada no método "run", que é invocado
	da fila de evento, a fim de evitar problemas com roscas.*/

	/*------------------------------------------------------------------*/

	public PSODemo(boolean isProg) {
		this.isprog = isProg;
		try {
			EventQueue.invokeAndWait(this);
		} catch (Exception e) {
		}
	}

	public PSODemo() {
		this.isprog = false;
		try {
			EventQueue.invokeAndWait(this);
		} catch (Exception e) {
		}
	}

	public PSODemo(String title) {
		this(false);
		this.setTitle(title);
	}

	/*------------------------------------------------------------------*/

	public static void main(String args[]) { /* --- main function */
		PSODemo v = new PSODemo(true);
	} /* main() *//* create an swarm demo viewer / criar um visualizador de demonstração enxame */

} /* class PSODemo */