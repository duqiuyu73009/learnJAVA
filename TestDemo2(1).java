 class Test{
 	public static void main(String[] args) { 
 		try { 
 			login("admin", "123456"); 
 			} catch (UserError userError) { 
			 	userError.printStackTrace(); 
 			} catch (PasswordError passwordError) { 
				passwordError.printStackTrace(); 
 			} 
	} 

	public static void login(String userName, String password) throws UserError, PasswordError { 
 			if (!Test.userName.equals(userName)) { 
 				throw new UserError("用户名错误"); 
 			} 
 			if (!Test.password.equals(password)) { 
 				throw new PasswordError("密码错误"); 
 			} 
 			System.out.println("登陆成功"); 
		}
	 }
 