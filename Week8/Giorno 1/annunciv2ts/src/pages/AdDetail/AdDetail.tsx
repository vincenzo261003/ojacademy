import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom'
import { LayoutPage } from '../../layout/LayoutHoc';
import { getAll, getByCode } from '../../services/ad.services';
import { Ad } from '../../interfaces/ad.interface';
import { CircularProgress, Container } from '@mui/material'
import AdCard from '../../components/Home/AdCard';


const AdDetail = () => {

    const [annuncio, setAnnuncio] = useState<Ad>();

    const [elenco, setElenco] = useState<Ad[]>([]);

    const { id } = useParams<string>();

    const navigate = useNavigate();

    useEffect(() => {

        window.scrollTo({top: 0, behavior: 'smooth'})

        getByCode(id).then( 
            res => {
                if (res.status === "ok"){
                    if (res.data) {
                        setAnnuncio(res.data);
                    }
                }
            }
        )

        getAll().then(
            res => {
                if (res.status === "ok"){
                    if (res.data) {
                        setElenco(res.data);
                    }
                }
            }
        )
        
    }, [id])

    return (
        <>
            <Container style={{marginBottom: 50}}>
                {annuncio ?
                <>
                    <h1>Titolo: {annuncio?.titolo}</h1>
                    <h3>Testo: {annuncio?.testo}</h3>
                    <br />
                    <h5>Utente: {annuncio?.utente.username}</h5>
                    <h5>Data di pubblicazione: {annuncio?.publicazione}</h5>
                </>
                :
                <CircularProgress />}

                {elenco[0] ?
                <>
                    {elenco.filter(x => (x.utente.username === annuncio?.utente.username && x.codice != annuncio?.codice) ).map((obj, idx) => (
                    <AdCard key={idx} titolo={obj.titolo} testo={obj.testo} publicazione={obj.publicazione} codice={obj.codice} utente={obj.utente} navigate={navigate}/>
                    ))}
                </>
                :
                <CircularProgress />}
            </Container>
        </>
    )
}

const LayoutAdDetail = LayoutPage(AdDetail);

export default LayoutAdDetail;