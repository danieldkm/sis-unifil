package bim2.trab1.huffman;

public class HuffmanNode extends HuffmanTree {
	public final HuffmanTree left, right; // subtrees

	public HuffmanNode(HuffmanTree l, HuffmanTree r) {
		super(l.frequency + r.frequency);
		left = l;
		right = r;
	}
}
