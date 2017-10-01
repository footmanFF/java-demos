package com.fm

/**
 * @author zhangli on 2017/9/18.
 */
class Testtt {

////    double a = 1000.1111
////    double b = 100.0
////    double c = 0.9999
//
//    double a = 1.1
//    double b = 0
//    double c = -2
//    double d = 3.0
//
//    Object someMethond() {
//        return (a+b)/(c*d)*(a-b)
////        return a+b*99-(600-3*15)/(((68-9)-3)*2-100)+10000%7*71*c
//    }
//
//    public static void main(String[] args) {
//        Testtt testtt = new Testtt();
//        print(testtt.someMethond())
//    }

    double f_call_1m_person_cnt_bigdata=2
    double f_call_3m_person_cnt_bigdata=2
    double f_mobile_on_months_bigdata=2
    double f_rate_level_clmg=2
    double f_call_3m_cnt_bigdata=2
    double f_mobile_call_cnt_bigdata=6
    Object calculate() {
        return (f_mobile_call_cnt_bigdata+++f_call_3m_person_cnt_bigdata)/(f_call_3m_cnt_bigdata*f_call_1m_person_cnt_bigdata)*(f_rate_level_clmg)-(f_mobile_on_months_bigdata)
    }

    public static void main(String[] args) {
        Testtt t = new Testtt();
        println t.calculate()
    }

}
