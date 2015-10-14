package Snapchat;

import java.util.*;

public class KSnapPoint {
	public static class Point {
		public int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public boolean equals(Object point) {
			if (!(point instanceof Point)) {
				return false;
			}
			Point p = (Point) point;
			return this.x == p.x && this.y == p.y;
		}

		public int hashCode() {
			return (x + " " + y).hashCode();
		}
	}

	public boolean isSnapPoint(Point p, int k) {
		int x = Math.abs(p.x);
		int y = Math.abs(p.y);
		int val = 0;
		while (x > 0) {
			val += x % 10;
			x /= 10;
		}
		while (y > 0) {
			val += y % 10;
			y /= 10;
		}
		return val <= k;
	}

	public HashSet<Point> ReachableKSnapPoint(int k) {
		HashSet<Point> points = new HashSet<Point>();
		if (k < 0)
			return points;
		helper(new Point(0, 0), k, points);
		return points;
	}

	public void helper(Point point, int k, HashSet<Point> points) {
		if (!isSnapPoint(point, k))
			return;
		points.add(point);
		Point left = new Point(point.x - 1, point.y);
		if (!points.contains(left))
			helper(left, k, points);
		Point right = new Point(point.x + 1, point.y);
		if (!points.contains(right))
			helper(right, k, points);
		Point upper = new Point(point.x, point.y + 1);
		if (!points.contains(upper))
			helper(upper, k, points);
		Point lower = new Point(point.x, point.y - 1);
		if (!points.contains(lower))
			helper(lower, k, points);
	}

	public static void main(String args[]) {
		KSnapPoint ks = new KSnapPoint();
		Point p = new Point(0, -100);
		Point p2 = new Point(0, 1);
		System.out.println(p.hashCode());
		System.out.println(ks.isSnapPoint(p, 2));
		HashSet<Point> set = ks.ReachableKSnapPoint(1);
		for (Point i : set) {
			System.out.print(i.x + " " + i.y + " ");
		}
	}
}
