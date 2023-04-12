import React, { useState } from 'react';

function SquadraComponent2(props) {

    const [goal, setGoal] = useState(0);

    function decrementaPunteggio(){
        setGoal(goal === 0 ? goal : goal-1)
        
    }

    function incrementaPunteggio(){
        setGoal(goal + 1)
    }

    

    return (
        <div className="row text-center">
            <h3 className='mt-5'>{props.squadra}</h3>
            <div className="col-4 mt-4">
                <button type='button' className='btn btn-primary' onClick={decrementaPunteggio}>-</button>
            </div>
            <div className="col-4 mt-4"><h1>{goal}</h1></div>
            <div className="col-4 mt-4">
                <button type='button' className='btn btn-primary' onClick={incrementaPunteggio}>+</button>
            </div>
        </div>
    );
}

export default SquadraComponent2;