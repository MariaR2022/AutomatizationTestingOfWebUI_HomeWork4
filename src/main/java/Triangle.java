public class Triangle {
    public static void main(String[] args) {
        System.out.println( "Вычислим площадь треугольника" );
    }
    public static double triangleSquare(double a,double b,double c)
            throws IncorrectSideLengthException {
        if (a <= 0 || b <= 0 || c <= 0) throw new IncorrectSideLengthException("Введена отрицательная либо нулевая длина стороны");
        double p = (a + b + c) / 2;
        double square = Math.round(Math.sqrt(p * (p - a) * (p - b) * (p - c)) * 100) / 100D;
        if (square <= 0) {
            throw new IncorrectSideLengthException("Введенные стороны не образуют треугольник");
        }
        return square;
    }
}
