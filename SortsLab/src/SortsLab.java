/* Name: Michelle Olofsson
 * Lab: Sorts Lab
 * Block: H
 * Description: Test different sorting methods 
 */

//********************************************************************
//  Sortlab.java       Author:
//
//  Driver to exercise the use of several Sorting Arrays methods.
//********************************************************************

public class SortsLab {
	static final int MAX = 20;

	public SortsLab() {
		int[] list = new int[MAX], list2 = new int[MAX], list3 = new int[MAX], list4 = new int[MAX],
				list5 = new int[MAX];
		int[] list6 = new int[MAX];
		int qcount = 0, icount = 0, scount = 0, mcount = 0, qmiddle = 0, qrand = 0;
		boolean flag = false; // false = moves, true = comparisons

		// Random Order List//////////////////

		System.out.println("Random order lists ");
		ListSetup.MakeRandom(list);
		ListSetup.Copy(list, list2);
		ListSetup.Copy(list, list3);
		ListSetup.Copy(list, list4);
		ListSetup.Copy(list, list5);
		ListSetup.Copy(list, list6);

		// count comparisons
		flag = true;
		System.out.println("\nFLAG==TRUE so COUNTING COMPARISONS:\n");

		// System.out.println("List before sorting:");
		// ListSetup.Print (list);
		// System.out.println("Here is the list after the Insertion Sort. ");
		icount = Sorts.Insertion(list, icount, flag);
		// ListSetup.Print (list);
		System.out.println("Insertion sort count = " + icount);
		// System.out.println("Here is the list after the Selection Sort. ");
		scount = Sorts.Selection(list2, scount, flag);
		// ListSetup.Print (list2);
		System.out.println("Selection sort count = " + scount);
		// System.out.println("Here is the list after the Quicksort (split first). ");
		qcount = Sorts.QuickSort(list3, 0, list.length - 1, qcount, flag);
		// ListSetup.Print (list3);
		System.out.println("Quicksort count = " + qcount);
		// System.out.println("Here is the list after the Merge Sort. ");
		mcount = Sorts.mergeSort(list4, 0, list.length - 1, mcount, flag);
		// ListSetup.Print (list4);
		System.out.println("Mergesort count = " + mcount);
		qmiddle = Sorts.QuickMid(list5, 0, list.length - 1, qmiddle);
		System.out.println("Qmiddle count = " + qmiddle);
		qrand = Sorts.QuickRandom(list6, 0, list.length - 1, qrand);
		System.out.println("Qrand count = " + qrand + "\n");
		
		//reset
		ListSetup.MakeRandom(list);
		ListSetup.Copy(list, list2);
		ListSetup.Copy(list, list3);
		ListSetup.Copy(list, list4);
		ListSetup.Copy(list, list5);
		ListSetup.Copy(list, list6);
		qcount = 0;
		icount = 0;
		scount = 0;
		mcount = 0;
		qmiddle = 0;
		qrand = 0;

		// count moves
		flag = false;
		System.out.println("FLAG==FALSE so COUNTING MOVES:\n");

		// System.out.println("List before sorting:");
		// ListSetup.Print (list);
		// System.out.println("Here is the list after the Insertion Sort. ");
		icount = Sorts.Insertion(list, icount, flag);
		// ListSetup.Print (list);
		System.out.println("Insertion sort count = " + icount);
		// System.out.println("Here is the list after the Selection Sort. ");
		scount = Sorts.Selection(list2, scount, flag);
		// ListSetup.Print (list2);
		System.out.println("Selection sort count = " + scount);
		// System.out.println("Here is the list after the Quicksort (split first). ");
		qcount = Sorts.QuickSort(list3, 0, list.length - 1, qcount, flag);
		// ListSetup.Print (list3);
		System.out.println("Quicksort count = " + qcount);
		// System.out.println("Here is the list after the Merge Sort. ");
		mcount = Sorts.mergeSort(list4, 0, list.length - 1, mcount, flag);
		// ListSetup.Print (list4);
		System.out.println("Mergesort count = " + mcount);
		qmiddle = Sorts.QuickMid(list5, 0, list.length - 1, qmiddle);
		System.out.println("Qmiddle count = " + qmiddle);
		qrand = Sorts.QuickRandom(list6, 0, list.length - 1, qrand);
		System.out.println("Qrand count = " + qrand + "\n");

		// Ascending Order List//////////////////

		System.out.println("\nAscending order lists ");
		ListSetup.MakeInOrder(list);
		ListSetup.Copy(list, list2);
		ListSetup.Copy(list, list3);
		ListSetup.Copy(list, list4);
		ListSetup.Copy(list, list5);
		ListSetup.Copy(list, list6);

		qcount = 0;
		icount = 0;
		scount = 0;
		mcount = 0;
		qmiddle = 0;
		qrand = 0;

		// count comparisons
		flag = true;
		System.out.println("\nFLAG==TRUE so COUNTING COMPARISONS:\n");

		icount = Sorts.Insertion(list, icount, flag);
		System.out.println("Insertion sort count = " + icount);
		scount = Sorts.Selection(list2, scount, flag);
		System.out.println("Selection sort count = " + scount);
		qcount = Sorts.QuickSort(list3, 0, list.length - 1, qcount, flag);
		System.out.println("Quicksort count = " + qcount);
		mcount = Sorts.mergeSort(list4, 0, list.length - 1, mcount, flag);
		System.out.println("Mergesort count = " + mcount);
		qmiddle = Sorts.QuickMid(list5, 0, list.length - 1, qmiddle);
		System.out.println("Qmiddle count = " + qmiddle);
		qrand = Sorts.QuickRandom(list6, 0, list.length - 1, qrand);
		System.out.println("Qrand count = " + qrand + "\n");
		
		// reset
		ListSetup.MakeInOrder(list);
		ListSetup.Copy(list, list2);
		ListSetup.Copy(list, list3);
		ListSetup.Copy(list, list4);
		ListSetup.Copy(list, list5);
		ListSetup.Copy(list, list6);
		qcount = 0;
		icount = 0;
		scount = 0;
		mcount = 0;
		qmiddle = 0;
		qrand = 0;

		// count moves
		flag = false;
		System.out.println("FLAG==FALSE so COUNTING MOVES: \n");

		icount = Sorts.Insertion(list, icount, flag);
		System.out.println("Insertion sort count = " + icount);
		scount = Sorts.Selection(list2, scount, flag);
		System.out.println("Selection sort count = " + scount);
		qcount = Sorts.QuickSort(list3, 0, list.length - 1, qcount, flag);
		System.out.println("Quicksort count = " + qcount);
		mcount = Sorts.mergeSort(list4, 0, list.length - 1, mcount, flag);
		System.out.println("Mergesort count = " + mcount);
		qmiddle = Sorts.QuickMid(list5, 0, list.length - 1, qmiddle);
		System.out.println("Qmiddle count = " + qmiddle);
		qrand = Sorts.QuickRandom(list6, 0, list.length - 1, qrand);
		System.out.println("Qrand count = " + qrand + "\n");

		// Descending Order List//////////////////

		System.out.println("\nDescending order lists ");
		ListSetup.MakeReverse(list);

		ListSetup.Copy(list, list2);
		ListSetup.Copy(list, list3);
		ListSetup.Copy(list, list4);
		ListSetup.Copy(list, list5);
		ListSetup.Copy(list, list6);

		qcount = 0;
		icount = 0;
		scount = 0;
		mcount = 0;
		qmiddle = 0;
		qrand = 0;

		// count comparisons
		flag = true;
		System.out.println("\nFLAG==TRUE so COUNTING COMPARISONS:\n");

		icount = Sorts.Insertion(list, icount, flag);
		System.out.println("Insertion sort count = " + icount);
		scount = Sorts.Selection(list2, scount, flag);
		System.out.println("Selection sort count = " + scount);
		qcount = Sorts.QuickSort(list3, 0, list.length - 1, qcount, flag);
		System.out.println("Quicksort count = " + qcount);
		mcount = Sorts.mergeSort(list4, 0, list.length - 1, mcount, flag);
		System.out.println("Mergesort count = " + mcount);
		qmiddle = Sorts.QuickMid(list5, 0, list.length - 1, qmiddle);
		System.out.println("Qmiddle count = " + qmiddle);
		qrand = Sorts.QuickRandom(list6, 0, list.length - 1, qrand);
		System.out.println("Qrand count = " + qrand + "\n");
		
		//reset
		ListSetup.MakeReverse(list);
		ListSetup.Copy(list, list2);
		ListSetup.Copy(list, list3);
		ListSetup.Copy(list, list4);
		ListSetup.Copy(list, list5);
		ListSetup.Copy(list, list6);
		qcount = 0;
		icount = 0;
		scount = 0;
		mcount = 0;
		qmiddle = 0;
		qrand = 0;

		// count moves
		flag = false;
		System.out.println("FLAG==FALSE so COUNTING MOVES: \n");

		icount = Sorts.Insertion(list, icount, flag);
		System.out.println("Insertion sort count = " + icount);
		scount = Sorts.Selection(list2, scount, flag);
		System.out.println("Selection sort count = " + scount);
		qcount = Sorts.QuickSort(list3, 0, list.length - 1, qcount, flag);
		System.out.println("Quicksort count = " + qcount);
		mcount = Sorts.mergeSort(list4, 0, list.length - 1, mcount, flag);
		System.out.println("Mergesort count = " + mcount);
		qmiddle = Sorts.QuickMid(list5, 0, list.length - 1, qmiddle);
		System.out.println("Qmiddle count = " + qmiddle);
		qrand = Sorts.QuickRandom(list6, 0, list.length - 1, qrand);
		System.out.println("Qrand count = " + qrand);

	}

	public static void main(String args[]) {

		new SortsLab();
	}
}