package com.lastMinute.exercise.services;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.lastMinute.exercise.exception.LastMinuteException;

/**
 * Class for dispatching services. We use the Dispatcher for centralizing all
 * the request so we could add some security checks or whatever We also could
 * insert here error handling, for example, to translate error messages  
 *
 */
public class Dispatcher {

	private final static Logger logger = Logger.getLogger(Dispatcher.class);

	/** Dispatches a service
	 * @param service the service to be dispatched
	 * @param json the recived json
	 * @return
	 * @throws LastMinuteException
	 */
	public JSONObject dispatch(IService service, String json) throws LastMinuteException {
		try {
			// Here could be some security check code or some common code but
			// it's not defined in the
			// exercise
			service.validate(json);
			return service.execute(json);
		} catch (LastMinuteException e) {
			// Here could be some error handling code but it's not defined in
			// the exercise
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

}
