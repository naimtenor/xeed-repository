package sally.se;

public class SEException extends Throwable {

	/**
	 * serial version uid
	 */
	private static final long serialVersionUID = 8005833366061658754L;
	
	private MessageCode messageCode;
	
	private Throwable cause;
	
	public SEException(MessageCode messageCode) {
		this.messageCode = messageCode;
	}
	
	public SEException(MessageCode messageCode, Throwable cause) {
		this.messageCode = messageCode;
		this.setCause(cause);
	}

	public MessageCode getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(MessageCode messageCode) {
		this.messageCode = messageCode;
	}

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

}
