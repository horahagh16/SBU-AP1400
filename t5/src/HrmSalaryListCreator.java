class HrmSalaryListCreator extends SalaryListCreator {
    public HrmSalaryListCreator(Encoder encoder) {
        super(encoder);
    }

    @Override
    protected String doCreate(Employee[] employees) {
        String finaly = "";
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            employee.setCode(addZeroPrefix(employee.getCode(), 8));
            finaly = finaly + employee.getCode() + getItemSeparator();
            long salary = employee.getSalary();
            String salaryy = Long.toString(salary);
            salaryy = addZeroPrefix(salaryy, 10);
            if (i == employees.length - 1) {
                finaly = finaly + salaryy;
            } else
                finaly = finaly + salaryy + getRecordSeparator();
        }
        return finaly;
    }
}
