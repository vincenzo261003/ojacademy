import React from 'react';
import { useParams } from 'react-router-dom'
import { LayoutPage } from '../../layout/LayoutHoc';

const AdDetail = () => {

    const { id } = useParams() 

    return (
        <>
        <h1>Ciao detail {id}</h1>
        </>
    )
}

const LayoutAdDetail = LayoutPage(AdDetail);

export default LayoutAdDetail;