package cn.com.wj.cn.com.wj.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Author：wangjie
 * Date：2019-09-10 15:33
 * Description：<描述>
 */
public class Test {

    protected static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {

        Object[] elementData = new Object[2];
        int i=0;
        

        elementData[i++] = "s";
        logger.info(elementData.length+"");
        logger.info(elementData[0]+"");
        logger.info(i+"");
    }
}
