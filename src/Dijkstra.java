import java.util.ArrayList;
import java.util.Stack;

public class Dijkstra {
	private int[][] data;
	private int size;
	private int[] distance;
	private int[] path;
	private int start, end;
	private final int INFINITE = Integer.MAX_VALUE;

	private Dijkstra() {
		this.start = 0;
		this.end = 0;
	}

	public Dijkstra(int[][] data) {
		this();
		this.data = data;
		size = data.length;
	}

	// 매개변수값은 정렬된 리스트의 인덱스 값
	public void performed(int st, int end) {
		this.start = st;
		this.end = end;

		// int infinite = Integer.MAX_VALUE;
		int tmpMin, tmpIndex = 0;

		boolean[] visit = new boolean[size];
		distance = new int[size];
		path = new int[size];

		// Initialize
		for (int i = 0; i < size; i++) {
			distance[i] = INFINITE;
			visit[i] = false;
			path[i] = -1;
		}

		// start point distance is 0.
		distance[st] = 0;

		int[][] test = new int[size][size];

		for (int i = 0; i < size; i++) {
			tmpMin = INFINITE;
			for (int j = 0; j < size; j++) {
				if (visit[j] == false && distance[j] < tmpMin) {
					tmpIndex = j;
					tmpMin = distance[j];
				}
			}

			// visit check
			visit[tmpIndex] = true;

			// search success so that break
			if (tmpIndex == end) {
				break;
			}

			if (tmpMin == INFINITE)
				break;

			for (int j = 0; j < size; j++) {
				if (distance[j] > distance[tmpIndex] + data[tmpIndex][j]) {
					distance[j] = distance[tmpIndex] + data[tmpIndex][j];
					path[j] = tmpIndex;
					test[i][j] = tmpIndex;
				}
			}
		}
	}

	public int getStart() {
		return start;
	}

	public int getDistanceOfIndex(int i) {
		return distance[i];
	}
	
	 public int[] getDistance() {
		 return distance;
	 }

	public ArrayList<Integer> getPathList() {
		ArrayList<Integer> resultList = new ArrayList<>();
		Stack<Integer> pathInStack = new Stack<>();
		int pointer = end;

		while (true) {
			if (path[pointer] != -1 && start != end) {
				pathInStack.push(pointer);
				pointer = path[pointer];
			} else {
				pathInStack.push(start);
				break;
			}
		}

		while (!pathInStack.empty())
			resultList.add(pathInStack.pop());

		return resultList;
	}

	// test
	void printArr(int[][] data) {
		int len = data.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				System.out.print(data[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
