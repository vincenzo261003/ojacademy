import React, { useEffect, useState } from 'react';
import { LayoutPage } from '../../layout/LayoutHoc';
import { SearchForm } from '../../components/Home/SearchForm';
import { Container } from '@mui/material'
import { getAll } from '../../services/ad.services';
import { Ad } from '../../interfaces/ad.interface';
import AdCard from '../../components/Home/AdCard';
import { useNavigate } from 'react-router-dom';

const Home = () => {

    const [elenco, setElenco] = useState<Ad[]>([]);

    const [listaFiltrata, setListaFiltrata] = useState<Ad[]>([]);

    const navigate = useNavigate();

    useEffect(() => {
        getAll().then(
            res => {
                if (res.status === "ok"){
                    if (res.data) {
                        setElenco(res.data);
                        setListaFiltrata(res.data);
                    }
                }
            }
        )
        
    }, [])

    const searchAd = (title: string, description: string, username: string) => {
        setListaFiltrata(elenco.filter(x => (x.titolo.toUpperCase().includes(title.toUpperCase()) && x.testo.toUpperCase().includes(description.toUpperCase()) && x.utente.username.toUpperCase().includes(username.toUpperCase()))));
    }

    return (
        <>
        <Container style={{marginBottom: 50}}>
            <SearchForm search={searchAd} />
            {listaFiltrata.map((obj, idx) => (
                <AdCard key={idx} titolo={obj.titolo} testo={obj.testo} publicazione={obj.publicazione} codice={obj.codice} utente={obj.utente} navigate={navigate}/>
            ))}
        </Container>
        </>
    );
}

const LayoutHome = LayoutPage(Home);

export default LayoutHome;