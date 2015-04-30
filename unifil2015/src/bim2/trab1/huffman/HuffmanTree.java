package bim2.trab1.huffman;

public abstract class HuffmanTree {
	public final int frequency; // the frequency of this tree

	public HuffmanTree(int freq) {
		frequency = freq;
	}

	// compares on the frequency
	public int compareTo(HuffmanTree tree) {
		return frequency - tree.frequency;
	}
}
