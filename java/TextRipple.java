import java.util.Random;

public class TextRipple {
    static int width = 80, height = 25;
    static float[][] oldWave, newWave;
    static final char[] CHARS = " .:-=+*#%@".toCharArray();
    static Random rnd = new Random();

    public static void main(String[] args) throws Exception {
        oldWave = new float[height][width];
        newWave = new float[height][width];
        long delay = 50;

        System.out.println("Press Ctrl+C to stop.\n");
        for (int frame = 0; ; frame++) {
            if (frame % 25 == 0) dropRandom(); // create ripples occasionally
            simulate();
            render(frame);
            Thread.sleep(delay);
        }
    }

    static void dropRandom() {
        int r = rnd.nextInt(height - 4) + 2;
        int c = rnd.nextInt(width - 4) + 2;
        oldWave[r][c] = 5f; // splash intensity
    }

    static void simulate() {
        for (int r = 1; r < height - 1; r++) {
            for (int c = 1; c < width - 1; c++) {
                // simple wave equation
                newWave[r][c] = (
                    oldWave[r - 1][c] +
                    oldWave[r + 1][c] +
                    oldWave[r][c - 1] +
                    oldWave[r][c + 1]
                ) / 2 - newWave[r][c];
                newWave[r][c] *= 0.985f; // damping
            }
        }
        // swap
        float[][] temp = oldWave;
        oldWave = newWave;
        newWave = temp;
    }

    static void render(int frame) {
        StringBuilder sb = new StringBuilder("\033[H"); // move cursor home
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                float v = oldWave[r][c];
                int idx = (int) Math.max(0, Math.min(CHARS.length - 1, (v + 5) / 10 * CHARS.length));
                sb.append(CHARS[idx]);
            }
            sb.append('\n');
        }
        sb.append("Frame: ").append(frame).append('\n');
        System.out.print(sb);
    }
}
