/*
 * Copyright (c) 2013, Joshua Kaplan
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *  - Redistributions of source code must retain the above copyright notice, this list of conditions and the following
 *    disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 *    following disclaimer in the documentation and/or other materials provided with the distribution.
 *  - Neither the name of matlabcontrol nor the names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package matlabcontrol.link;

import matlabcontrol.MatlabInvocationException;
import matlabcontrol.MatlabOperations;
import matlabcontrol.MatlabProxy;

/**
 *
 * @since 4.2.0
 * @author <a href="mailto:nonother@gmail.com">Joshua Kaplan</a>
 */
public final class LinkedOperations implements MatlabOperations {
	private final MatlabProxy _delegateProxy;
	private final MatlabOperations _delegateOperations;

	public LinkedOperations(MatlabProxy proxy) {
		_delegateProxy = proxy;
		_delegateOperations = Linker.getLinkedMatlabOperations(proxy);
	}

	@Override
	public void eval(String command) throws MatlabInvocationException {
		_delegateOperations.eval(command);
	}

	@Override
	public Object[] returningEval(String command, int nargout) throws MatlabInvocationException {
		return _delegateOperations.returningEval(command, nargout);
	}

	@Override
	public void feval(String functionName, Object... args) throws MatlabInvocationException {
		_delegateOperations.feval(functionName, args);
	}

	@Override
	public Object[] returningFeval(String functionName, int nargout, Object... args) throws MatlabInvocationException {
		return _delegateOperations.returningFeval(functionName, nargout, args);
	}

	@Override
	public void setVariable(String variableName, Object value) throws MatlabInvocationException {
		_delegateOperations.setVariable(variableName, value);
	}

	@Override
	public Object getVariable(String variableName) throws MatlabInvocationException {
		return _delegateOperations.getVariable(variableName);
	}

	/**
	 * The proxy used to communicate with MATLAB.
	 * 
	 * @return proxy
	 */
	public MatlabProxy getDelegateProxy() {
		return _delegateProxy;
	}
}
