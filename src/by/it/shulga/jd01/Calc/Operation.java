package by.it.shulga.jd01.Calc;

interface Operation {
    Var add(Var other);
    Var sub(Var other);
    Var mul(Var other);
    Var div(Var other);

    Var add(Scalar other);
    Var sub(Scalar other);
    Var mul(Scalar other);
    Var div(Scalar other);

    Var add(Vector other);
    Var sub(Vector other);
    Var mul(Vector other);
    Var div(Vector other);

}