import React, { useEffect, useState } from 'react';
import DashboardHeader from "./dashboard-header/DashboardHeader";
import DashboardBody from "./dashboard-body/DashboardBody";
import { ServiceSpend } from "./ServiceSpend";

const useServiceSpends = () => {
  const [serviceSpends, setServiceSpends] = useState<Array<ServiceSpend>>([])
  useEffect(() => {
    fetch(`http://localhost:8080/spending/service`).then(result => {
      return result.json()
    }).then(val => {
      setServiceSpends(val)
    })
  }, [])
  return serviceSpends
}

const Dashboard = () => {
  const serviceSpends = useServiceSpends();

  return (
    <div className="Dashboard">
      <DashboardHeader/>
      <DashboardBody items={serviceSpends} />
    </div>
  );
}

export default Dashboard;
