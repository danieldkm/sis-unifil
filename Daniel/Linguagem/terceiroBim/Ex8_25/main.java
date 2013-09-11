package Ex8_25;

public class main {

	public static void main(String[] args) {
		DataHoraV1 dh1 = new DataHoraV1((byte)01, (byte)01,(short) 2013, (byte)22, (byte)12, (byte)30);
		DataHoraV2 dh2 = new DataHoraV2((byte)01, (byte)01,(short) 2013, (byte)22, (byte)12, (byte)30);
		System.out.println("V1\n " + dh1+"\n");
		System.out.println("V2\n " + dh2);
	}

}
