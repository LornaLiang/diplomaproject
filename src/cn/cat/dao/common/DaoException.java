/**
 * 
 */
package cn.cat.dao.common;

/**
 * @author lorna
 *
 */
public class DaoException extends RuntimeException {

	private static final long serialVersionUID = 7654158635758949352L;
	private int code;
	
	/**表示数据库连接失败*/
	public static final int CODE_CONNECTION_FAIL = 100;
	
	public DaoException() {
		super();
	}

	public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public DaoException(int code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}


	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message) {
		super(message);
	}
	
	public DaoException(int code) {
		this.code = code;
	}

	public DaoException(Throwable cause) {
		super(cause);
	}
	
	public int getCode(){
		return code;
	}
}
