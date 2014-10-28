package List;

import java.util.ArrayList;

public class MultiArrayList<E> {

	private ArrayList<ArrayList<E>> _array;
	private int rowCount;
	private int columnCount;

	public MultiArrayList() {
		this._array = new ArrayList<>();
		this.rowCount = 0;
		this.columnCount = 0;
	}

	/**
	 * 행 추가하기
	 * 
	 * @return
	 */
	public boolean addRow() {
		boolean chk = true;

		this.rowCount++;

		// insert row
		chk = _array.add(new ArrayList<E>());

		// 현재 컬럼 수 만큼 새로운 로우에 컬럼추가
		for (int i = 0; i < columnCount; i++) {
			chk = chk && _array.get(rowCount - 1).add(null);
			// chk = chk && _array.get(rowCount - 1).add((E) new Integer(0)); //
			// test
		}
		return chk;
	}

	/**
	 * 열 추가하기
	 * 
	 * @return
	 */
	public boolean addColumn() {
		boolean chk = true;
		this.columnCount++;
		// 현재 로우 있느냐 없느냐 확인
		if (rowCount == 0) {
			// throw new Exception("row size is 0.");
			System.err.println("row size is 0.");
		}

		// 컬럼 추가
		for (int i = 0; i < _array.size(); i++) {
			chk = chk && _array.get(i).add(null);
			// chk = chk && _array.get(i).add((E) new Integer(0)); // test
		}
		return chk;
	}

	/**
	 * 행 삭제하기
	 * 
	 * @param index
	 *            - the index of the element to be removed
	 * @return the element that was removed from the list
	 * @throws IndexOutOfBoundsException
	 *             - if the index is out of range (index < 0 || index >= size())
	 */
	public ArrayList<E> removeRow(int index) {
		rowCount--;
		return _array.remove(index);
	}

	/**
	 * 열 삭제하기
	 * 
	 * @param index
	 *            - the index of the element to be removed
	 * @return the element that was removed from the list
	 * @throws IndexOutOfBoundsException
	 *             - if the index is out of range (index < 0 || index >= size())
	 */
	public ArrayList<E> removeColumn(int index) {
		ArrayList<E> temp = new ArrayList<>();
		columnCount--;
		for (int i = 0; i < rowCount; i++) {
			temp.add(_array.get(i).remove(index));
		}
		return temp;

	}

	/**
	 * 행 가져오기
	 * 
	 * @param index
	 * @return
	 */
	public ArrayList<E> getRow(int index) {
		return _array.get(index);
	}

	/**
	 * 열 가져오기
	 * 
	 * @param index
	 * @return
	 */
	public ArrayList<E> getColumn(int index) {
		ArrayList<E> temp = new ArrayList<E>();
		for (int i = 0; i < _array.size(); i++) {
			E e = _array.get(i).get(index);
			temp.add(e);
		}
		return temp;
	}

	public E get(int row, int column) {
		return _array.get(row).get(column);
	}

	public ArrayList<E> setRow(int index, ArrayList<E> arr) {
		return _array.set(index, arr);
	}

	public Object set(int row, int column, E data) {
		return _array.get(row).set(column, data);
	}

	public int sizeOfRow() {
		return rowCount;
	}

	public int sizeOfColumn() {
		return columnCount;
	}

	public int indexOf(E e) {

		return 1;
	}

	// test ///////////////////////////////////////////////////////////
	/**
	 * 현재 배열 모두 출력
	 */
	public void printAllElements() {
		System.out.println("---");
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				System.out.print(_array.get(row).get(column).toString()
						+ (column + 1 != columnCount ? " | " : ""));
			}
			System.out.println();
		}
		System.out.println("---");
	}

	@Override
	public String toString() {
		return "";
	}
}
