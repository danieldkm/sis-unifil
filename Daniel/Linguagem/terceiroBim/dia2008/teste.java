package dia2008;

public class teste {
	class Ponto2D{
		private int x,y;
		Ponto2D(int _x, int _y){
			x = _x;
			y = _y;
		}
		
	}

	
	class Ponto3D extends Ponto2D{
		private int z,w;
		
//		Ponto3D(){
//			System.out.println("erro");
//		}
		

		Ponto3D(int _x, int _y, int _z){
			super(_x,_y);
			z = _z;
		}
		
		Ponto3D(int _x, int _y, int _z, int w){
			this(_x, _y, _z);
			this.w = w;
		}
		
	}
}
