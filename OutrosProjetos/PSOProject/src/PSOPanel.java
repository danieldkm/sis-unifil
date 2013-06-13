import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.util.Random;

/*--------------------------------------------------------------------*/
public class PSOPanel extends JPanel {
	/*--------------------------------------------------------------------*/
	private static final long serialVersionUID = 1L;

	/* --- instance variables --- */
	private int fnid; /* function identifier */
	private Color[] fcols; /* colors for function display */
	private BufferedImage bkgnd; /* buffer for background */
	private Particle[] swarm; /* particle swarm */
	private double accel; /* acceleration factor */
	private double decel; /* initial deceleration factor */
	private double decay; /* deceleration parameter */
	private Random rand; /* random number generator */
	private double bx, by; /* best location seen (globally) */
	private double best; /* function value at best location */
	private int step; /* step of optimization */

	/*------------------------------------------------------------------*/

	public PSOPanel() { /* --- create a PSO panel */
		this.fnid = 0; /* set the first function */
		this.fcols = new Color[256];/* initialize the colors */
		for (int i = 256; --i >= 0;)
			this.fcols[i] = new Color(i / 255.0F, i / 255.0F, i / 255.0F);
		this.bkgnd = null; /* clear the image */
	} /* PSOPanel() */

	/*------------------------------------------------------------------*/

	public boolean hasSwarm() {
		return (this.swarm != null);
	}

	public int getStep() {
		return this.step;
	}

	public double getBest() {
		return this.best;
	}

	public double getBestX() {
		return this.bx;
	}

	public double getBestY() {
		return this.by;
	}

	/*------------------------------------------------------------------*/

	public void setFn(int id) { /* --- set the function to optimize */
		if (id == this.fnid)
			return;
		this.fnid = id;
		this.swarm = null;
		this.bkgnd = null;
		this.repaint();
	} /* setFn() */

	/*------------------------------------------------------------------*/

	private double feval(double x, double y) { /* --- evaluate the function */
		switch (this.fnid) { /* evaluate the function id */
		case 1:
			x = x * x + y * y;
			return Math.cos(48 * Math.sqrt(x)) - 4 * x;
		case 2:
			x = x * x + y * y;
			return Math.cos(96 * Math.sqrt(x)) - 4 * x;
		case 3:
			return 0.5 * (Math.cos(31.4 * x) + Math.cos(31.4 * y)) - 4
					* (x * x + y * y);
		case 4:
			return 0.5 * (Math.cos(62.8 * x) + Math.cos(62.8 * y)) - 4
					* (x * x + y * y);
		default:
			return -4 * (x * x + y * y);
		} /* compute the function value */
	} /* feval() */

	/*------------------------------------------------------------------*/

	public void createSwarm(int cnt, int size, double accel, double decel,
			double decay, Random rand) { /* --- create a particle swarm */
		int i; /* loop variable */
		Particle p; /* to traverse the particles */
		double v; /* buffer for function value */

		this.accel = accel; /* note the parameters */
		this.decel = decel; /* and init. the variables */
		this.decay = decay;
		this.rand = rand;
		this.step = 0;
		this.best = -Double.MAX_VALUE;
		this.swarm = new Particle[cnt];
		for (i = cnt; --i >= 0;) { /* create the particle swarm */
			this.swarm[i] = p = new Particle(size, rand);
			v = feval(p.x[0], p.y[0]); /* compute the initial function value */
			p.best = v; /* and set it as the locally best */
			if (v > this.best) { /* find globally best function value */
				this.best = v;
				this.bx = p.x[0];
				this.by = p.y[0];
			}
		}
		this.repaint(); /* draw the swarm */
	} /* createSwarm() */

	/*------------------------------------------------------------------*/

	public void updateSwarm() { /* --- update the particle swarm */
		int i, k; /* loop variable, history position */
		Particle p; /* to traverse the particles */
		double alpha; /* velocity decay factor */
		double v; /* buffer for function value */

		if (this.swarm == null)
			return;
		alpha = this.decel * Math.pow(++this.step, -this.decay);
		for (i = this.swarm.length; --i >= 0;) {
			p = this.swarm[i]; /* traverse the particles */
			p.update(alpha, this.accel * this.rand.nextDouble(), this.accel
					* this.rand.nextDouble(), this.bx, this.by);
			k = p.hpos; /* update the particle location */
			v = feval(p.x[k], p.y[k]); /* compute the new function value */
			if (v > p.best) { /* update best local function value */
				p.best = v;
				p.bx = p.x[k];
				p.by = p.y[k];
			}
			if (v > this.best) { /* update best global function value */
				this.best = v;
				this.bx = p.x[k];
				this.by = p.y[k];
			}
		}
		this.repaint(); /* redraw the swarm */
	} /* updateSwarm() */

	/*------------------------------------------------------------------*/

	public void paint(Graphics g) { /* --- (re)paint the whole panel */
		int i; /* loop variable */
		Dimension d; /* (preferred) size of panel */
		int w, h; /* size of background rectangle */
		int x, y; /* loop variables for pixels */
		int c; /* color index for pixel */
		Graphics bg; /* graphics for background image */
		double[][] vals; /* matrix of function values */
		double min, max, v; /* (min./max.) function value */
		Particle p; /* to traverse the particles */

		d = this.getSize(); /* get the panel size */
		w = d.width;
		h = d.height; /* (width and height) */
		if ((this.bkgnd != null) /* if the window size changed */
				&& ((w != this.bkgnd.getWidth()) || (h != this.bkgnd
						.getHeight())))
			this.bkgnd = null; /* delete the buffered background */
		if (this.bkgnd == null) { /* if there is no buffered background */
			this.bkgnd = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
			bg = this.bkgnd.getGraphics();
			vals = new double[w][h]; /* create function matrix */
			min = Double.MAX_VALUE;
			max = -Double.MAX_VALUE;
			for (x = w; --x >= 0;) { /* traverse the pixels */
				for (y = h; --y >= 0;) {
					v = feval((x / (double) (w - 1)) - 0.5,
							0.5 - (y / (double) (h - 1)));
					vals[x][y] = v; /* compute the function per pixel */
					if (v < min)
						min = v; /* find minimum and maximum */
					if (v > max)
						max = v; /* of the function values */
				} /* for the color scaling */
			}
			v = 255.0 / 1.04 / (max - min);
			min -= 0.02 * (max - min); /* compute the color scaling factor */
			for (x = w; --x >= 0;) { /* traverse the pixels again */
				for (y = h; --y >= 0;) {
					c = (int) (v * (vals[x][y] - min));
					if (c < 0)
						c = 0;
					else if (c > 255)
						c = 255;
					bg.setColor(this.fcols[c]);
					bg.fillRect(x, y, 1, 1);
				} /* compute the color index and */
			} /* color the pixel according */
		} /* to the function value */
		g.drawImage(this.bkgnd, 0, 0, null);
		if (this.swarm == null)
			return;
		for (i = this.swarm.length; --i >= 0;)
			this.swarm[i].drawBest(g, w, h);
		for (i = this.swarm.length; --i >= 0;)
			this.swarm[i].drawTail(g, w, h);
		for (i = this.swarm.length; --i >= 0;)
			this.swarm[i].draw(g, w, h);
		x = (int) ((0.5 + this.bx) * (w - 1));
		y = (int) ((0.5 - this.by) * (h - 1));
		g.setColor(Color.blue);
		g.drawLine(x - 12, y, x + 12, y);
		g.drawLine(x, y - 12, x, y + 12);
		g.setColor(Color.black);
		g.fillOval(x - 5, y - 5, 11, 11);
		g.setColor(Color.white);
		g.fillOval(x - 4, y - 4, 9, 9);
		g.setColor(Color.blue);
		g.fillOval(x - 3, y - 3, 7, 7);
	} /* paint() */

	/*------------------------------------------------------------------*/

	public BufferedImage makeImage() { /* --- create an image of contents */
		BufferedImage img; /* created image */
		Dimension d; /* size of panel */

		d = this.getPreferredSize();
		img = new BufferedImage(d.width, d.height, BufferedImage.TYPE_3BYTE_BGR);
		this.paint(img.getGraphics());
		return img; /* draw window contents to image */
	} /* BufferedImage() *//* and return the image */

} /* class PSOPanel */
