import React, {useContext, useEffect, useState} from 'react';
import { useParams } from 'react-router-dom'
import Context from './Context';
import DatePicker from 'react-datepicker'
import "react-datepicker/dist/react-datepicker.css";
import DayDetail from './DayDetail';


function DetailComponent(props) {

    const { id } = useParams();

    const { elenco, aggiorna, getImgUrl } = useContext(Context);

    const [film, setFilm] = useState();

    const [startDate, setStartDate] = useState(new Date());

    useEffect(() => {
        var s = elenco.filter(x => x.EventId == id)[0];
        setFilm(s);
    }, [elenco])

    useEffect(() => {
        aggiorna();
    }, [])

    const getTrailerUrl = (stringa) => {
        stringa.includes("youtu.be") ? (stringa = stringa.replace("youtu.be", "www.youtube.com/embed")) : (stringa = stringa.replace("watch?v=", "embed/"));
        (stringa.indexOf("&") != -1) ?? (stringa = stringa.slice(0, stringa.indexOf("&")));
        console.log(stringa)
        return stringa;
    }

    return (
        <>
        {
            film ?
                <div className='container-fluid text-white py-3' style={{backgroundColor: '#3b3d40'}}>
                    <div className="container">
                        <div className="row mb-3">
                            <h2 style={{color: 'aqua'}}>Dettagli del film: {film.Title}</h2>
                            <h4>Titolo originale: {film.OriginalTitle}</h4>
                            <h6>Direttore: {film.Director}</h6>
                            <h6>Durata: {film.Duration}H</h6>

                            <h6 className='text-warning'>Caratteristiche: {film.Properties}</h6>
                        </div>
                        <div className="row">
                            <div className="col-md-3 col-12">
                                <img className="w-100" src={getImgUrl(film.Picture)} />
                            </div>
                            <div className="col-md-9 col-12">
                                <h3>Descrizione:</h3>
                                <p>{film.Description}</p>
                                {
                                    (film.Actors.trim()) &&
                                    <>
                                        <h3 className='pt-3'>Attori:</h3>
                                        <p>{film.Actors}</p>
                                    </>
                                }
                            </div>
                        </div>

                        <div className="row my-5">
                            <div className="col-6">
                                <h3>Scegli la data dello spettacolo: </h3>
                            </div>
                            
                            <div className='col-6'>
                                <DatePicker
                                    showIcon
                                    selected={startDate}
                                    onChange={(date) => setStartDate(date)}
                                />
                            </div>

                            <div className="col-12">
                            {film.Days.filter(obj => {
                                const day = new Date(obj.Day.slice(0, -9));
                                const formattedDate = day.toISOString().slice(0, 10); // convert to yyyy-mm-dd format
                                return formattedDate === startDate.toISOString().slice(0, 10);
                            }).map((obj, idx) => <DayDetail key={idx} day={obj} />)}
                            </div>
                        </div>

                        {
                            film.MovieId.trim() != "" &&
                                <div className="row mt-4">
                                    <h1 onClick={() => console.log(film.MovieId)} >Guarda il trailer:</h1>
                                    <iframe width="100%" height="600px" src={getTrailerUrl(film.MovieId)} title="YouTube video player" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowFullScreen></iframe>
                                </div>
                        }
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

export default DetailComponent;