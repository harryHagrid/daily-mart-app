import React, { useState, useEffect } from 'react';

function ToastMessage(props) {

    const [message, setMessage] = useState('');
    const { stopTime, response, required } = props;

    useEffect(() => {

        console.log(props);

        setMessage(response)
        if(required) {
            console.log("required");
            
            clearMessageInterval(stopTime)
        }
        

    }, [response])

    const clearMessageInterval = (stopTime) => {
        let startTime = new Date().getTime();
        let interval = setInterval(() => {

            if (new Date().getTime() - startTime > stopTime) {

                clearInterval(interval);
                setMessage('')
            }
        }, 500)

    }

    return (
        <div>
            <span>
                <h6>
                    {message}
                </h6>
            </span>
        </div>
    );
}

export default ToastMessage;

