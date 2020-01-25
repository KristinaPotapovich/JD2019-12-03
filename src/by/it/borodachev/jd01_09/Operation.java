package by.it.borodachev.jd01_09;

interface Operation {
   Var add(Var newValue) throws Exception;

   Var sub(Var newValue) throws Exception;
   Var mul(Var newValue) throws Exception;

   Var div(Var newValue) throws Exception;

}
