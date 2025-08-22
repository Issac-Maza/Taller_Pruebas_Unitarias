package tallerpruebas;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Assume;

public class Test {
	private Employee workerUSD, workerOtraOcurrencia;
	private Employee supervisorUSD, supervisorOtraOcurrencia;
	private Employee managerUSD, managerOtraOcurrencia;
	private int month;
	private static final float RMU = 386f;
	private static final float DECIMO = RMU / 12f * 2f; 
	private static final float EPS = 0.01f;

	@org.junit.Before
	public void declaracionesiniciales() {
	    workerUSD = new Employee(1200f, "USD", 0f, EmployeeType.Worker);
	    workerOtraOcurrencia = new Employee(1200f, "EUR", 0f, EmployeeType.Worker);
	    supervisorUSD = new Employee(1300f, "USD", 0.10f, EmployeeType.Supervisor);
	    supervisorOtraOcurrencia = new Employee(1300f, "libras", 0.10f, EmployeeType.Supervisor);
	    managerUSD = new Employee(1700f, "USD", 0.20f, EmployeeType.Manager);
	    managerOtraOcurrencia = new Employee(1700f, "PESOS", 0.20f, EmployeeType.Manager);
	    month = LocalDate.now().getMonthValue();
	  }
	
	// COWORKER USD Y MES PAR
	 @org.junit.Test
	 public void testCsWorkerUSDPar() {
	     Assume.assumeTrue(month % 2 == 0);
	     float expected = 1200f;
	     assertEquals(expected, workerUSD.cs(), EPS);
	 }
	    
	 // COWORKER USD Y MES IMPAR

	 @org.junit.Test
	 public void testCsWorkerUSDImpar() {
	     Assume.assumeFalse(month % 2 == 0);
	     float expected = 1200f + DECIMO;
	     assertEquals(expected, workerUSD.cs(), EPS);
   }
	    
	 // COWORKER OTRA MONEDA Y MES PAR
	 @org.junit.Test
	 public void testCsWorkerOtraOcurrenciaPar() {
	     Assume.assumeTrue(month % 2 == 0);
	     float expected = 1200f * 0.95f;
	     assertEquals(expected, workerOtraOcurrencia.cs(), EPS);
	    }

	   // COWORKER OTRA MONEDA Y MES IMPAR
	  @org.junit.Test
	  public void testCsWorkerOtraOcurrenciaImpar() {
	      Assume.assumeFalse(month % 2 == 0);
	      float expected = (1200f * 0.95f) + DECIMO;
	      assertEquals(expected, workerOtraOcurrencia.cs(), EPS);
	    }
	  
	  
	  // SUPERVISOR
	  
	  @org.junit.Test
	    public void testCsSupervisorUSDPar() {
	        Assume.assumeTrue(month % 2 == 0);
	        float expected = 1300f + (0.10f * 0.35f);
	        assertEquals(expected, supervisorUSD.cs(), EPS);
	    }

	  @org.junit.Test
	    public void testCsSupervisorUSDImpar() {
	        Assume.assumeFalse(month % 2 == 0);
	        float expected = 1300f + (0.10f * 0.35f) + DECIMO;
	        assertEquals(expected, supervisorUSD.cs(), EPS);
	    }

	  @org.junit.Test
	    public void testCsSupervisorOtraOcurrenciaPar() {
	        Assume.assumeTrue(month % 2 == 0);
	        float expected = (1300f * 0.95f) + (0.10f * 0.35f);
	        assertEquals(expected, supervisorOtraOcurrencia.cs(), EPS);
	    }

	  @org.junit.Test
	    public void testCsSupervisorOtraOcurrenciaImpar() {
	        Assume.assumeFalse(month % 2 == 0);
	        float expected = (1300f * 0.95f) + (0.10f * 0.35f) + DECIMO;
	        assertEquals(expected, supervisorOtraOcurrencia.cs(), EPS);
	    }
	  
	  
	  	// MANAGER 
	  
	  @org.junit.Test
	    public void testCsManagerUSDPar() {
	        Assume.assumeTrue(month % 2 == 0);
	        float expected = 1700f + (0.20f * 0.7f);
	        assertEquals(expected, managerUSD.cs(), EPS);
	    }

	  @org.junit.Test
	    public void testCsManagerUSDImpar() {
	        Assume.assumeFalse(month % 2 == 0);
	        float expected = 1700f + (0.20f * 0.7f) + DECIMO;
	        assertEquals(expected, managerUSD.cs(), EPS);
	    }

	  @org.junit.Test
	    public void testCsManagerOtraOcurrenciaPar() {
	        Assume.assumeTrue(month % 2 == 0);
	        float expected = (1700f * 0.95f) + (0.20f * 0.7f);
	        assertEquals(expected, managerOtraOcurrencia.cs(), EPS);
	    }

	  @org.junit.Test
	    public void testCsManagerOtraOcurrenciaImpar() {
	        Assume.assumeFalse(month % 2 == 0);
	        float expected = (1700f * 0.95f) + (0.20f * 0.7f) + DECIMO;
	        assertEquals(expected, managerOtraOcurrencia.cs(), EPS);
	    }
	  
	  
	  
	  	// CALCULO DEL COSTO ANUAL
	  
	  	//WORKER
	  @org.junit.Test
	  public void testCalculateYearBonusWorkerUSD() {
	      float expected = 386f;
	      assertEquals(expected, workerUSD.CalculateYearBonus(), 0.01f);
	  }

	  @org.junit.Test
	  public void testCalculateYearBonusWorkerOtraOcurrencia() {
	      float expected = 386.0f; 
	      assertEquals(expected, workerOtraOcurrencia.CalculateYearBonus(), 0.01f);
	  }
	  
	 
	  	// SUPERVISOR 
	  
	  @org.junit.Test
	  public void testCalculateYearBonusSupervisorUSD() {
	      float expected = 1300.0f + 386.0f * 0.5f;
	      assertEquals(expected, supervisorUSD.CalculateYearBonus(), 0.01f);
	  }

	  @org.junit.Test
	  public void testCalculateYearBonusSupervisorOtraOcurrencia() {
	      float expected = (1300.0f * 0.95f) + 386.0f * 0.5f;
	      assertEquals(expected, supervisorOtraOcurrencia.CalculateYearBonus(), 0.01f);
	  }

	  
	  	// MANAGER
	  @org.junit.Test
	  public void testCalculateYearBonusManagerUSD() {
	      float expected = 1700.0f + 386.0f * 1.0f;
	      assertEquals(expected, managerUSD.CalculateYearBonus(), 0.01f);
	  }

	  @org.junit.Test
	  public void testCalculateYearBonusManagerOtraOcurrencia() {
	      float expected = (1700.0f * 0.95f) + 386.0f * 1.0f;
	      assertEquals(expected, managerOtraOcurrencia.CalculateYearBonus(), 0.01f);
	  }
	  
	  
	}
	  
	  
