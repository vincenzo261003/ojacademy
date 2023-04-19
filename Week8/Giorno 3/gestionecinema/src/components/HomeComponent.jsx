import React, {useContext, useEffect} from 'react';
import Context from './Context';
import FilmComponent from './FilmComponent';

function HomeComponent() {

    const { elenco, aggiorna, getImgUrl } = useContext(Context);

    useEffect(() => {
        aggiorna();
    }, [])

    return (
        <>
        {
            elenco[0] ?
                <div className='container-fluid text-white py-3' style={{backgroundColor: '#3b3d40'}}>
                    <h1>Lista completa film</h1>
                    <div className="row">
                        {elenco.map((obj, idx) => <FilmComponent key={idx} film={obj} />)}
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

export default HomeComponent;