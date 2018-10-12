package diffprocessor;

/**
 * Created by VavilauA on 6/19/2015.
 */
public class Processor {

    private void removeProcess(SortedLimitedList<Double> mustBeEqualTo, SortedLimitedList<Double> expectedOutput) {
        SortedLimitedList.Entry<Double> ptr1 = mustBeEqualTo.first;
        SortedLimitedList.Entry<Double> ptr2 = expectedOutput.first;
        while (ptr1 != null) {
            if (ptr2 == null || ptr1.getValue() < ptr2.getValue()) {
                SortedLimitedList.Entry<Double> for_remove = ptr1;
                ptr1 = ptr1.getNext();
                mustBeEqualTo.remove(for_remove);
            } else if (ptr1.getValue() > ptr2.getValue()) {
                ptr2 = ptr2.getNext();
            } else {
                ptr1 = ptr1.getNext();
                ptr2 = ptr2.getNext();
            }
        }
    }

    private void addProcess(SortedLimitedList<Double> mustBeEqualTo, SortedLimitedList<Double> expectedOutput) {
        SortedLimitedList.Entry<Double> ptr1 = mustBeEqualTo.first;
        SortedLimitedList.Entry<Double> ptr2 = expectedOutput.first;
        while (ptr2 != null) {
            if (ptr1 == null) {
                mustBeEqualTo.addLast(ptr2.getValue());
                ptr2 = ptr2.getNext();
            } else if (ptr1.getValue() > ptr2.getValue()) {
                mustBeEqualTo.addBefore(ptr1, ptr2.getValue());
                ptr2 = ptr2.getNext();
            } else if (ptr1.getValue() < ptr2.getValue()) {
                ptr1 = ptr1.getNext();
            } else {
                ptr1 = ptr1.getNext();
                ptr2 = ptr2.getNext();
            }
        }
    }

    public Processor(long limit) {
        // TODO: initialize.
    }

    public void doProcess(SortedLimitedList<Double> mustBeEqualTo, SortedLimitedList<Double> expectedOutput) {
        // TODO: make "mustBeEqualTo" list equal to "expectedOutput".
        // 0. Processor will be created once and then will be used billion times.
        // 1. Use methods: AddFirst, AddLast, AddBefore, AddAfter, Remove to modify list.
        // 2. Do not change expectedOutput list.
        // 3. At any time number of elements in list could not exceed the "Limit".
        // 4. "Limit" will be passed into Processor's constructor. All "mustBeEqualTo" and "expectedOutput" lists will have the same "Limit" value.
        // 5. At any time list elements must be in non-descending order.
        // 6. Implementation must perform minimal possible number of actions (AddFirst, AddLast, AddBefore, AddAfter, Remove).
        // 7. Implementation must be fast and do not allocate excess memory.
        removeProcess(mustBeEqualTo, expectedOutput);
        addProcess(mustBeEqualTo, expectedOutput);
    }


}
