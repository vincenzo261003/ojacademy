import React, {useContext, useEffect, useState} from 'react';
import Context from './Context';
import FilmComponent from './FilmComponent';
import "react-datepicker/dist/react-datepicker.css";
import DatePicker from 'react-datepicker'


function OrdinatiGiorno() {

    const { elenco, aggiorna, getImgUrl } = useContext(Context);

    const [startDate, setStartDate] = useState(new Date());

    useEffect(() => {
        aggiorna();
    }, [])

    return (
        <>
        {
            elenco[0] ?
                <div className='container-fluid text-white py-3' style={{backgroundColor: '#3b3d40'}}>
                    <div className="row">
                        <div className="col-7"><h1>Lista film del</h1>
                        
                        <DatePicker
                                showIcon
                                selected={startDate}
                                onChange={(date) => setStartDate(date)}
                            /></div>
                    </div>
                    <div className="row">
                    {elenco.map((obj, idx) => (
                        obj.Days.some(x => {
                            const day = new Date(x.Day.slice(0, -9));
                            const today = startDate;
                            return day.getFullYear() === today.getFullYear() && day.getMonth() === today.getMonth() && day.getDate() === today.getDate();
                        }) && <FilmComponent key={idx} film={obj} />
                        ))}                    
                    </div>
                </div>
            :
                <div className='container-fluid text-white py-3 text-center' style={{backgroundColor: '#3b3d40'}}>
                    <div className="spinner-border text-warning" role="status">
                        <span className="sr-only">Loading...</span>
                    </div>
                </div>
        }
        </>
    );
}

export default OrdinatiGiorno;