import React, { useState } from 'react';
import { Grid, TextField, Button } from '@mui/material'

export const SearchForm = ({search} : SearchFormProps) => {

    const [title, setTitle] = useState<string>("");
    const [description, setDescription] = useState<string>("");
    const [username, setUsername] = useState<string>("");

    return (
        <>
            <Grid container spacing={2}>
                <Grid item md={4} xs={12}>
                    <TextField label="Titolo" id='title' variant='outlined' fullWidth 
                    value={title}
                    onChange={(event : React.ChangeEvent<HTMLInputElement>) => {
                        setTitle(event.target.value);
                    }}/>
                </Grid>
                <Grid item md={4} xs={12}>
                    <TextField label="Descrizione" id='description' variant='outlined' fullWidth
                    value={description}
                    onChange={(event : React.ChangeEvent<HTMLInputElement>) => {
                        setDescription(event.target.value);
                    }}/>
                </Grid>
                <Grid item md={4} xs={12}>
                    <TextField label="Utente" id='username' variant='outlined' fullWidth
                    value={username}
                    onChange={(event : React.ChangeEvent<HTMLInputElement>) => {
                        setUsername(event.target.value);
                    }}/>
                </Grid>
            </Grid>
            <Grid container style={{marginTop:20}}>
                <Grid item xs={12}>
                    <Button variant='contained' fullWidth onClick={() => search(title, description, username)}>Cerca</Button>
                </Grid>
            </Grid>
        </>
    )
}


type SearchFormProps = {
    search: (title: string, description: string, username: string) => void
}