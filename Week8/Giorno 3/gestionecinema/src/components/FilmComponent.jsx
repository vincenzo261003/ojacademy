import React, { useContext } from 'react';
import Context from './Context';
import { Link } from 'react-router-dom';


function FilmComponent(props) {

    const { getImgUrl } = useContext(Context);

    return (
        <>
            <div className="col-lg-3 col-md-4 col-12 col-sm-6 p-3">
                <div className="card w-100 h-100 text-black">
                {(props.film.Properties) && <button type="button" readonly className="btn btn-warning text-white text-bold">{props.film.Properties.toString()}</button>}
                    <img className="card-img-top w-100" src={getImgUrl(props.film.Picture)} alt="Card image cap" />
                    <div className="card-body d-flex flex-column">
                        <h5 className="card-title">{props.film.Title}</h5>
                        <p className="card-text">{(props.film.Description).substring(0, 150) + " ..."}</p>
                        <Link href="#" class="btn btn-primary w-100 mt-auto" to={"/" + props.film.EventId}>
                           Dettagli
                        </Link>
                    </div>
                </div>
            </div>
        </>
    );
}

export default FilmComponent;