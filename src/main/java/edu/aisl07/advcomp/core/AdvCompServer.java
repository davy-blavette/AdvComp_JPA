package edu.aisl07.advcomp.core;

import edu.aisl07.advcomp.AdvCompException;

public interface AdvCompServer {

	AdvCompService connect(String login, String password) throws AdvCompException;

}