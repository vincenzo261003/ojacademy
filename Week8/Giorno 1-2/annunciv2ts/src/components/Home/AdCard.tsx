import React from 'react';
import { Card, CardActionArea, CardContent, Typography, CardActions, Button, Link } from '@mui/material'
import { Ad } from '../../interfaces/ad.interface';

const AdCard = (props: Ad) => {

    return (
        <>
            <Card style={{marginTop: 20}}>
                <CardActionArea>
                    <CardContent>
                        <Typography gutterBottom variant="h5" component="div">
                            {props.titolo}
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                            {props.testo}
                        </Typography>
                        <Typography variant="caption" color="text.primary">
                            <br/>
                            Utente: {props.utente.username}
                        </Typography>
                    </CardContent>

                    <CardActions>
                        <Button size="small" color="primary" onClick={() => props.navigate("/detail/" + props.codice)}>
                            VISUALIZZA
                        </Button>
                    </CardActions>
                </CardActionArea>
            </Card>
        </>
    )

}

export default AdCard;