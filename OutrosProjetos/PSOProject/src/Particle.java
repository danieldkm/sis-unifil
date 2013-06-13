import java.awt.*;
import java.util.Random;

/*--------------------------------------------------------------------*/
class Particle {
	/*--------------------------------------------------------------------*/

	/* --- instance variables --- */
	protected double[] x, y; /* locations in parameter space  / localizações no espaço parâmetro*/
	protected double vx, vy; /* velocity vector / vetor velocidade*/
	protected double bx, by; /* best location seen (locally) / melhor localização visto (localmente)*/
	protected double best; /* best function value / melhor valor da função*/
	protected int size; /* size of history / tamanho da história*/
	protected int hpos; /* position in history / posição na história*/

	/*------------------------------------------------------------------*/

	private void init(int size, double x, double y) { /* --- create tail colors / criar cores da cauda*/
		int i; /* loop variable / variável do laço*/
		float t; /* buffer for intensity / tampão para a intensidade*/
		
		this.bx = x;
		this.vx = 0; /* store the location and / armazenar o local e*/
		this.by = y;
		this.vy = 0; /* clear the velocity vector / limpar o vetor velocidade*/
		this.hpos = 0;
		this.size = ++size;
		this.x = new double[size]; /* initialize the history / inicializar a história */
		this.y = new double[size];
		for (i = size; --i >= 0;) {
			this.x[i] = x;
			this.y[i] = y;
		}
	} /* createColors() */

	/*------------------------------------------------------------------*/

	public Particle(int size, double x, double y) {
		this.init(size, x, y);
	}

	/*------------------------------------------------------------------*/

	public Particle(int size, Random rand) { /* --- create a particle / criar uma partícula*/
		double rx, ry; /* particle location / localização de partículas*/

		do {
			rx = (rand.nextDouble() - 0.5) * 0.96;
			ry = (rand.nextDouble() - 0.5) * 0.96;
		} while (rx * rx + ry * ry < 0.09); /* generate a random position / gerar uma posição aleatória */ 
		this.init(size, rx, ry); /* not too close to the center / não muito perto do centro */
	} /* Particle() */

	/*------------------------------------------------------------------*/

	public void update(double alpha, double beta1, double beta2, double gx,
			double gy) { /* --- update a particle / atualizar uma partícula*/
		double cx = this.x[this.hpos];
		double cy = this.y[this.hpos];
		this.vx = alpha * this.vx + beta1 * (this.bx - cx) + beta2 * (gx - cx);
		this.vy = alpha * this.vy + beta1 * (this.by - cy) + beta2 * (gy - cy);
		this.hpos = (this.hpos + 1) % this.size;
		this.x[this.hpos] = cx += this.vx; /* update particle velocity / atualizar velocidade da partícula*/
		this.y[this.hpos] = cy += this.vy; /* and particle location / e localização de partículas*/
	} /* update() */

	/*------------------------------------------------------------------*/

	public void drawBest(Graphics g, int w, int h) { /* --- draw best location  / desenhar melhor localização*/
		int sx = (int) ((0.5 + this.bx) * (w - 1));
		int sy = (int) ((0.5 - this.by) * (h - 1));
		g.setColor(Color.blue); /* draw a blue cross / desenhar uma cruz azul*/
		g.drawLine(sx - 2, sy, sx + 2, sy); /* at the best location / com a melhor localização*/
		g.drawLine(sx, sy - 2, sx, sy + 2); /* (local memory) / (memória local)*/
	} /* drawBest() */

	/*------------------------------------------------------------------*/

	public void drawTail(Graphics g, int w, int h) { /* draw tail of a particle / desenhar cauda de uma partícula*/
		int i; /* loop variable / variável do laço*/
		int nx, ny, ox, oy; /* particle locations / locais de partículas*/

		if (this.size <= 1)
			return;
		g.setColor(Color.red); /* draw history lines in red / desenhar linhas história em vermelho*/
		i = (this.hpos + 1) % this.size;
		nx = (int) ((0.5 + this.x[i]) * (w - 1));
		ny = (int) ((0.5 - this.y[i]) * (h - 1));
		do { /* compute the oldest location / calcular o local mais antigo*/
			ox = nx;
			oy = ny; /* and then traverse the newer / e, em seguida, atravessar a mais nova*/
			i = (i + 1) % this.size; /* locations drawing lines / locais desenhando linhas*/
			nx = (int) ((0.5 + this.x[i]) * (w - 1));
			ny = (int) ((0.5 - this.y[i]) * (h - 1));
			g.drawLine(ox, oy, nx, ny);
		} while (i != this.hpos); /* while not at end of history / embora não no fim da história*/
	} /* drawTail() */

	/*------------------------------------------------------------------*/

	public void draw(Graphics g, int w, int h) { /* --- draw a particle / desenhar uma partícula*/
		int sx = (int) ((0.5 + this.x[this.hpos]) * (w - 1));
		int sy = (int) ((0.5 - this.y[this.hpos]) * (h - 1));
		g.setColor(Color.black); /* draw a red disc / desenhar um disco vermelho*/
		g.fillOval(sx - 4, sy - 4, 9, 9); /* at the current location / na localização atual*/
		g.setColor(Color.red); /* outlined in black / esboçado no preto*/
		g.fillOval(sx - 3, sy - 3, 7, 7); /* for better visibility / para uma melhor visibilidade*/
	} /* draw() */

} /* class Particle */