package jadePingChecker;

public class CmdPrompt {

	private Runtime rt;
	private Process pr;

	public CmdPrompt() {
		rt = Runtime.getRuntime();
		pr = null;
	}

	// referenced this
	// https://www.linglom.com/programming/java/how-to-run-command-line-or-execute-external-application-from-java/
	// for how to run cmd line code from Java

	public void runCommand(String cmd) {
		try {
			pr = rt.exec("cmd /c " + Constants.PING_COMMAND);

		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

	}
}
