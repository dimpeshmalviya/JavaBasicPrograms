import java.io.*;
import java.util.*;

public class RangeMinimumQuery {
    public static void build(int index, int low, int high, int[] arr, int[] seg) {
        if (low == high) {
            seg[index] = arr[low];
            return;
        }
        int mid = (low + high) >> 1;
        build(2 * index + 1, low, mid, arr, seg);
        build(2 * index + 2, mid + 1, high, arr, seg);
        seg[index] = Math.min(seg[2 * index + 1], seg[2 * index + 2]);
    }
    public static int query(int index, int low, int high, int l, int r, int[] seg) {
        if (r < low || high < l)
            return Integer.MAX_VALUE;
        if (l <= low && high <= r)
            return seg[index];
        int mid = (low + high) >> 1;
        int left = query(2 * index + 1, low, mid, l, r, seg);
        int right = query(2 * index + 2, mid + 1, high, l, r, seg);
        return Math.min(left, right);
    }
    public static void update(int index, int low, int high, int pos, int value, int[] seg) {
        if (low == high) {
            seg[index] = value;
            return;
        }
        int mid = (low + high) >> 1;
        if (pos <= mid)
            update(2 * index + 1, low, mid, pos, value, seg);
        else
            update(2 * index + 2, mid + 1, high, pos, value, seg);
        seg[index] = Math.min(seg[2 * index + 1], seg[2 * index + 2]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] seg = new int[4 * n];
        build(0, 0, n - 1, arr, seg);
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int pos = Integer.parseInt(st.nextToken()) - 1;
                int val = Integer.parseInt(st.nextToken());
                update(0, 0, n - 1, pos, val, seg);
            } else {
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;
                output.append(query(0, 0, n - 1, l, r, seg)).append("\n");
            }
        }
        System.out.print(output);
    }
}
