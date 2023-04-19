import React, { useEffect } from 'react';

function DayDetail(props) {
  const { day } = props;

  useEffect(() => {
    console.log(day);
  }, [day]);

  return (
    <div className="card my-3 text-black ">
      <div className="card-body">
        <h5 className="card-title">{day.Performances[0].Screen}</h5>
        <h6 className="card-subtitle mb-2 text-muted">{day.Performances[0].Time}</h6>
        <p className="card-text">Durata: {day.Performances[0].Duration} minuti</p>
      </div>
    </div>
  );
}

export default DayDetail;
