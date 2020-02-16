package by.it.drozd.jd01_10;

class Bean {
    @Param(a=5,b=2)
    double sum(int a,int b){
    return a+b;
    }

    double avg(int a,int b){
    return (a+b)/2.0;
    }
    @Param(a=10,b=20)
    static double max(int a,int b){
    if(a>b){
        return a;
    }else{
        return b;
    }
    }
    @Param(a=19,b=21)
    static double min(int a,int b){
        if(a<b){
            return a;
        }else{
            return b;
        }
    }

}
