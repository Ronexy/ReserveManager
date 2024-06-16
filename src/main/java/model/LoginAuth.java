package model;


public class LoginAuth {
	public static boolean Authentication(String loginId, String password) {
		
		LoginDAO loginDAO = new LoginDAO();
		String passwordInDB = loginDAO.getPasswordByLoginId(loginId);
		
		
		if(passwordInDB != null && password.equals(passwordInDB)) {
			return true;
		}else {
			return false;
		}
	}
}
