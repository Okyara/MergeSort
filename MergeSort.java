public class MergeSort 
{
    int comp;

    public static void main(String[] args)
    {
        MergeSort obj = new MergeSort();

        Comparable[] array =  {"cat", "zebra", "dog","aardvark", "giraffe",
                               "fish","whale", "elephant", "hippopotamus",
                               "lion","monkey", "tiger"};

        System.out.println("Initial List:");
        for(int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }

        System.out.println();

        int count = obj.mergeSort(array);

        System.out.println("Sorted List:");
        for(int i = 0; i < array.length; i++)
        {
                System.out.println(array[i]);
        }

    }//main

    /**
     * Mergesort algorithm.
     * @param: array of Comparable items.
    */
    public int mergeSort( Comparable [ ] arr )
    {
        Comparable [ ] tmpArray = new Comparable[ arr.length ];
        return mergeSort( arr, tmpArray, 0, arr.length - 1 );
    }

    /**
    * Internal method that makes recursive calls.
    * @param a an array of Comparable items.
    * @param tmpArray an array to place the merged result.
    * @param left the left-most index of the subarray.
    * @param right the right-most index of the subarray.
    */
    private int mergeSort( Comparable [ ] arr, Comparable [ ] tmpArray,
                            int left, int right )
    {
        if( left < right )
        {
            int center = ( left + right ) / 2;
            mergeSort( arr, tmpArray, left, center );
            mergeSort( arr, tmpArray, center + 1, right );

            return merge( arr, tmpArray, left, center + 1, right );
        }

        return -1;
    }

    /**
    * Internal method that merges two sorted halves of a subarray.
    * @param a an array of Comparable items.
    * @param tmpArray an array to place the merged result.
    * @param leftPos the left-most index of the subarray.
    * @param rightPos the index of the start of the second half.
    * @param rightEnd the right-most index of the subarray.
    */
    private int merge( Comparable [ ] arr, Comparable [ ] tmpArray,
                        int leftPos, int rightPos, int rightEnd )
    {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // main loop
        while( leftPos <= leftEnd && rightPos <= rightEnd )
        {
            comp++;

            if( arr[ leftPos ].compareTo( arr[ rightPos ] ) <= 0 )
                tmpArray[ tmpPos++ ] = arr[ leftPos++ ];
            else
                tmpArray[ tmpPos++ ] = arr[ rightPos++ ];
        }

        // Copy rest of the first half.
        while( leftPos <= leftEnd )
            tmpArray[ tmpPos++ ] = arr[ leftPos++ ];

        // Copy rest of the second half.
        while( rightPos <= rightEnd )
            tmpArray[ tmpPos++ ] = arr[ rightPos++ ];

        // Copy tmpArray.
        for( int i = 0; i < numElements; i++, rightEnd-- )
            arr[ rightEnd ] = tmpArray[ rightEnd ];

        return comp;

    }//merge

}//MergeSort

/*********************************OUTPUT****************************************
 *  Initial List:
    cat
    zebra
    dog
    aardvark
    giraffe
    fish
    whale
    elephant
    hippopotamus
    lion
    monkey
    tiger

    Sorted List:
    aardvark
    cat
    dog
    elephant
    fish
    giraffe
    hippopotamus
    lion
    monkey
    tiger
    whale
    zebra

*/