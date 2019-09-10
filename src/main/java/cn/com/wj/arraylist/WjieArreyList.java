package cn.com.wj.arraylist;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 手写ArrayList
 *
 * @author wangjie
 * @version V1.0
 * @date 2019/9/10
 */
public class WjieArreyList<E> {


    private static final Logger logger = LoggerFactory.getLogger(WjieArreyList.class);
    /**
     * 容器默认大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 有参构造入参为0时的共享集合
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};

    /**
     * 无参构造时的共享集合
     */
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};

    /**
     * 底层数组
     */
    transient Object[] elementData;

    /**
     * 集合内部非空大小
     */
    private int size;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 有参构造
     * @param initSize 初始容器大小
     */
    public WjieArreyList(int initSize){

        if(0 < initSize){
            this.elementData = new Object[initSize];
        }else if(0 == initSize){
            this.elementData = EMPTY_ELEMENT_DATA;
        }else{
            logger.error("【构造入参大小不能小于零！】");
            throw new IllegalArgumentException("【构造入参大小不能小于零！】: "+
                    initSize);
        }
    }

    /**
     * 无参构造
     */
    public WjieArreyList() {
        this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
    }

    /**
     * 插入数据
     * @param e
     * @return
     */
    public boolean add(E e){
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    /**
     * 初始化容器
     * @param minCapacity
     */
    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    /**
     * 扩容
     * @param minCapacity
     */
    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0){
            grow(minCapacity);
        }
    }

    /**
     * 判断初始化大小
     * @param elementData
     * @param minCapacity
     * @return
     */
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    /**
     *初始化
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0){
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0){
            newCapacity = hugeCapacity(minCapacity);
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 容器最大容量
     * @param minCapacity
     * @return
     */
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

}
