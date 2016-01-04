package nio;

public class ByteUtils {

	public static byte[] intToByte(int i) {
		byte[] targets = new byte[4];
		targets[3] = (byte) (i & 0xFF);
		targets[2] = (byte) (i >> 8 & 0xFF);
		targets[1] = (byte) (i >> 16 & 0xFF);
		targets[0] = (byte) (i >> 24 & 0xFF);
		return targets;
	}

	public static int byteToInt(byte[] bytes, int off) {
		int b0 = bytes[off] & 0xFF;
		int b1 = bytes[off + 1] & 0xFF;
		int b2 = bytes[off + 2] & 0xFF;
		int b3 = bytes[off + 3] & 0xFF;
		return (b0 << 24) | (b1 << 16) | (b2 << 8) | b3;
	}
	
	public static void main(String[] args) {
		System.out.println("mGwrLK4YK75J8jFdP2Xh7sru4gO3NRpeOfiaBdRUVXTAKFBamcx008reMhbapxUkGPxIs6P5Wx4g14pyBWnYA37uF8JdNuEhZRTc".length());
	}

}
