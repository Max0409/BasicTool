/*
* @author:MAX
*/

public class MyArrayList {
    transient Object[] elementData;

    private static final int DEFAULT_CAPACITY=10;

    private static final Object[] EMPTY_ELEMENTDATA={};

    private static final Object[]  DEFAULTCAPACITY_EMPTY_ELEMENTDATA={};

    private int size;

    public MyArrayList(int initialCapacity){
        if (initialCapacity > 0) {
            this.elementData=new Object[initialCapacity];
        }else if(initialCapacity==0){
            this.elementData=EMPTY_ELEMENTDATA;
        }else {
            throw new IllegalArgumentException("Illegal Capacity:"+initialCapacity);

        }
    }


    public MyArrayList(){
        this(DEFAULT_CAPACITY);
    }


    public void add(Object o){
        ensureExplicitCapacity(size+1);
        elementData[size++]=o;


    }


    public void ensureExplicitCapacity(int minCapacity ){
        if(size==elementData.length){
            int oldCapacity=elementData.length;
            int newCapacity=oldCapacity+(oldCapacity>>1);
            if(newCapacity-minCapacity<0){
                newCapacity=minCapacity;
            }
            Object[] objects=new Object[newCapacity];
            System.arraycopy(elementData,0,objects,0,elementData.length);
            elementData=objects;

        }
    }

    public Object get(int index){
        rangeCheck(index);
        return elementData[index];

    }

    public void rangeCheck(int index){
        if(index>=size){
            throw new IndexOutOfBoundsException("out of bounds!");
    }
    }


    public Object remove(int index){
        rangeCheck(index);

        Object oldValue=elementData[index];

        int numMoved=size-index-1;
        if(numMoved>0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[--size]=null;
        return oldValue;

    }

    public boolean remove(Object o){
        for(int index=0;index<size;index++){
            if(o.equals(elementData[index])){
                remove(index);
                return true;

            }
        }
        return false;

    }

}

