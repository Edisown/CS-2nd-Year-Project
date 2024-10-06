/**
 * Author: Edison Malasan
 * 8/22/2024
 */
package PrelimProject;

public interface SortAlgoProfiler {

    long getBubbleSortStatementDate(Customer[] customer);
    long getInsertionSortStatementDate(Customer[] customer);
    long getSelectionSortStatementDate(Customer[] customer);
}
