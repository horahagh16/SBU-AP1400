public class FmSalaryListCreator extends SalaryListCreator {
    public FmSalaryListCreator(Encoder encoder) {
        super(encoder);
    }

    @Override
    protected String doCreate(Employee[] employees) {
        String finaly = "";
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            long salary = employee.getSalary();
            String salaryy = Long.toString(salary);
            salaryy = addZeroPrefix(salaryy, 10);
            finaly = finaly + salaryy + getItemSeparator();
            employee.setCode(addZeroPrefix(employee.getCode(), 10));
            if (i == employees.length - 1) {
                finaly = finaly + employee.getCode();
            } else
                finaly = finaly + employee.getCode() + getRecordSeparator();
        }
        return finaly;
    }
}
