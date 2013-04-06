package com.github.omerucel.jcosmos;

import com.github.omerucel.jcosmos.error.InternalServerError;

public class CommandManager {
    public Response execute(ICommand command)
    {
        Response response = null;

        try
        {
            response = command.run();
        }catch(Exception e){
            if (response == null)
                response = new Response();

            response.addError(new InternalServerError(e.getMessage()));
        }

        return response;
    }
}
