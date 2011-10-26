/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.mgwt.dom.client.event.mouse;

import java.util.LinkedList;

import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 * A collection of HandlerRegistrations which behaves like a single
 * registration: On remove all collected Handlers are removed.
 * 
 * @author Daniel Kurka
 * 
 */
public class HandlerRegistrationCollection implements HandlerRegistration {

	private LinkedList<HandlerRegistration> collectedHandlers = new LinkedList<HandlerRegistration>();

	/**
	 * Construct an empty HandlerRegistrationCollection
	 */
	public HandlerRegistrationCollection() {

	}

	/**
	 * Add a {@link HandlerRegistration} to the collection
	 * 
	 * @param handlerRegistration the handlerregistration to add
	 */
	public void addHandlerRegistration(HandlerRegistration handlerRegistration) {
		collectedHandlers.add(handlerRegistration);
	}

	/**
	 * Remove all handlers: Call remove on each Handler
	 */
	@Override
	public void removeHandler() {
		for (HandlerRegistration handlerRegistration : collectedHandlers) {
			handlerRegistration.removeHandler();
		}
		collectedHandlers.clear();

	}

}
