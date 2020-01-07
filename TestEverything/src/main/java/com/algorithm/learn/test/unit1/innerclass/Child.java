package com.algorithm.learn.test.unit1.innerclass;

/**
 * @author : ChenChangjiang
 */
public class Child {

    private class Boy extends Father {
        private String boy;

        public Boy() {
            boy = getFa();
        }

        public String getBoy() {
            return boy;
        }
    }

    private class Girl extends Mather {
        private String girl;

        public Girl() {
            girl = getMa();
        }

        public String getGirl() {
            return girl;
        }
    }

    public Boy getBoyClass() {
        return new Boy();
    }

    public Girl getGirlClass() {
        return new Girl();
    }

    public String getBoy() {
        return new Boy().getBoy();
    }

    public String getGirl() {
        return new Girl().getGirl();
    }

}
