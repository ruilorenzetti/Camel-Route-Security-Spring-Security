package de.bit.camel.security.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.camel.Exchange;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import de.bit.camel.security.Employee;

/**
 * 
 * @author TORKHANI Rami
 */
public class EmployeeBean {
    private Logger logger = Logger.getLogger(EmployeeBean.class);

    private SimpleJdbcTemplate simpleJdbcTemplate;
    private static final String QUERY_FOR_EMP = "select name, job_title, department, entry_date from employees where emp_id = ?";

    public Employee getEmployeeData(final String empId) {
        try {
            Employee emp = simpleJdbcTemplate.queryForObject(QUERY_FOR_EMP, new RowMapper<Employee>() {
                
                public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Employee emp = new Employee();
                    emp.setEmpId(empId);
                    emp.setName(rs.getString("name"));
                    emp.setJobTitle(rs.getString("job_title"));
                    emp.setDepartment(rs.getString("department"));
                    emp.setEntryDate(rs.getString("entry_date"));

                    return emp;
                }

            }, new Object[] {empId});

            logger.info("getEmployeeData for employee id " + empId + " returned " + emp.toString());

            return emp;
        } catch (EmptyResultDataAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Employee getEmptyEmployee(Exchange exchange) {
    	logger.error(exchange.getIn());
    	
    	return new Employee();    	
    }
    
    public boolean isServiceProprete(Employee employee) {
        return employee.getDepartment().equals("Proprete");
    }
    public boolean isServiceEtatCivil(Employee employee) {
        return employee.getDepartment().equals("Etat Civil");
    }

    @Required
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }
}
