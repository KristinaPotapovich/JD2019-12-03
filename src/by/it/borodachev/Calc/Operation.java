package by.it.borodachev.Calc;

interface Operation {
   Var add(Var newValue) throws Exception;

   Var sub(Var newValue) throws Exception;
   Var mul(Var newValue) throws Exception;

   Var div(Var newValue) throws Exception;

}
