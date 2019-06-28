Vagrant.configure("2") do |config|
  config.vm.box = "bento/ubuntu-18.04"

  config.vm.provider "virtualbox"

  config.vm.network "forwarded_port", host: 8180, guest: 8080

  config.vm.provision "docker" do |d|    
    d.run "swaggerapi/swagger-editor", args: "-p 8080:8080"
  end  
end
